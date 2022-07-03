package com.example.Code_Sharing_Platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.time.Duration;
import java.time.LocalTime;


@Controller
public class WebController {
    @Autowired
    CodesService codesService;


    @GetMapping("/code/latest")
    public String apiTenCodesHtml(Model model) {
        model.addAttribute("codes", codesService.repository.findLast());
        return "codeList";
    }


    @GetMapping("/code/{uuid}")
    public String getNew(@PathVariable String uuid, Model model) {
        try {
            Snippets s = codesService.repository.findByUUID(uuid);
            LocalTime end = LocalTime.now();
            Duration duration = Duration.between(ItemsController.start, end);
            if (s.getViews() > 0) {
                if (s.getViews() - 1 == 0) {
                    s.setViews(s.getViews() - 1);
                    codesService.repository.delete(s);
                } else {
                    s.setViews(s.getViews() - 1);
                    codesService.repository.save(s);
                }
            }
            if (s.getTime() > 0) {
                if (s.getTime() - 8 == 0) {
                    s.setTime(s.getTime() - 8);
                    codesService.repository.delete(s);
                } else {
                    s.setTime(s.getTime() - 8);
                    codesService.repository.save(s);
                }
            }
            model.addAttribute("date", s.getDate());
            model.addAttribute("code", s.getCode());
            model.addAttribute("time", s.getTime());
            model.addAttribute("views", s.getViews());
            model.addAttribute("viewsSecret", s.isViewsSecret());
            model.addAttribute("timeSecret", s.isTimeSecret());
            if (s.getViews() >= 0 & s.getTime() >= 0) {
                return "code";
            } else {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "entity not found"
                );
            }
        } catch (Exception ignored) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
    }


    @RequestMapping(value = "/code/new", method = RequestMethod.POST)
    public String snippetsSubmit(@ModelAttribute Snippets snippets, Model model) {
        codesService.repository.save(snippets);
        model.addAttribute("snippets", snippets);
        return "result";
    }

    @RequestMapping(value = "/code/new", method = RequestMethod.GET)
    public String getNewHtml(Model model) {
        model.addAttribute("snippets", new Snippets());
        return "create";
    }
}