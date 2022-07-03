package com.example.Code_Sharing_Platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.time.Duration;
import java.time.LocalTime;


@RestController
public class ItemsController {
    //    static Integer id = 1;
    @Autowired
    CodesService codesService;
    public  static LocalTime start = LocalTime.now();

    @RequestMapping("api/code/{uuid}")
    public ResponseEntity<?> api(@PathVariable String uuid) {
        try {
            Snippets s = codesService.repository.findByUUID(uuid);
            LocalTime end = LocalTime.now();
            Duration duration = Duration.between(start, end);
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
            if (s.getViews() >= 0 & s.getTime() >= 0) {
                return new ResponseEntity<>(s, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping("api/code/latest")
    public ResponseEntity<?> apiTenCodes() {
        return new ResponseEntity<>(codesService.repository.findLast(), HttpStatus.OK);
    }

    @PostMapping("api/code/new")
    public ResponseEntity<?> PostApi(@Validated @RequestBody Snippets snippets) {
        Snippets snippets1 = new Snippets(snippets.getCode(), snippets.getDate(), snippets.getTime(), snippets.getViews());
        codesService.repository.save(snippets1);
        return new ResponseEntity<>("{ \"id\" : \"" + codesService.repository.lastUuid() + "\" }", HttpStatus.OK);
    }
//    @RequestMapping("/code/new")
//    public ResponseEntity<String> codeNew() {
//        return ResponseEntity.ok().contentType(MediaType.TEXT_HTML)
//                .body(snippets.getHtmlNew());
//    }
//    @RequestMapping(method = RequestMethod.GET, value = "/api/code")
//    public Map<String, String> getCodeApi() {
//        map.put("code", "public static void main(String[] args) {\\n    SpringApplication.run(CodeSharingPlatform.class, args);\\n}");
//        return map;
//    }


//    @GetMapping(value = "/code")
//    public ModelAndView welcome() {
//        return new ModelAndView("code");
//    }

//    @RequestMapping("/code")
//    public ResponseEntity<String> handle() {
//        return ResponseEntity.ok().contentType(MediaType.TEXT_HTML)
//                .body(snippets.getHtml());
//    }
}