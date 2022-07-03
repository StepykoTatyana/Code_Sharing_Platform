package com.example.Code_Sharing_Platform;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Component
public class Snippets {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "bigint not null constraint user_pkey primary key")
    @JsonIgnore
    private Long id;

    @Column
    private String code = "public static void main(String[] args){SpringApplication.run(CodeSharingPlatform.class, args);}";

    @Column
    @DateTimeFormat
    private String date = FormatDateTimeExample.getDate();

    @JsonIgnore
    @Column
    private String uuid = UUID.randomUUID().toString();

    @Column
    private long time;

    @Column
    private int views;

    @JsonIgnore
    @Column
    private boolean viewsSecret;

    @JsonIgnore
    @Column
    private boolean timeSecret;

    public boolean isViewsSecret() {
        return viewsSecret;
    }

    public void setViewsSecret(boolean viewsSecret) {
        this.viewsSecret = viewsSecret;
    }

    public boolean isTimeSecret() {
        return timeSecret;
    }

    public void setTimeSecret(boolean timeSecret) {
        this.timeSecret = timeSecret;
    }

    public Snippets(String code, String date) {
        this.code = code;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Snippets() {
    }

    public Snippets(String code, String date, long time, int views) {
        this.code = code;
        this.date = date;
        this.time = time;
        this.views = views;
        this.viewsSecret = views > 0;
        this.timeSecret = time > 0;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @JsonIgnore
    public String getHtml() {
        return "<html xmlns:th=\"http://www.thymeleaf.org\">\n" +
                "<head>\n" +
                "    <title>Code</title>\n" +
                "    <script type=\"text/javascript\" src=\"function.js\"></script>\n" +
                "<link th:href=\"@{/css/style.css}\" rel=\"stylesheet\"/>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <span id=\"load_date\">" +
                this.date +
                "</pre id=\"code_snippet\">\n" +
                "    <pre>" +
                this.code +
                "</pre>\n" +
                "</body>\n" +
                "</html>";
    }

    @JsonIgnore
    public String getHtmlNew() {
        return "<html xmlns:th=\"http://www.thymeleaf.org\">\n" +
                "<head>\n" +
                "    <title>Create</title>\n" +
                "<link th:href=\"@{/css/style.css}\" rel=\"stylesheet\"/>" +
                "    <script type=\"text/javascript\" src=\"function.js\"></script>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <span id=\"load_date\">" +
                this.date +
                "</span>\n" +
                "<textarea  id=\"code_snippet\">\n" +
                this.code +
                "</textarea >\n" +
                "<button id=\"send_snippet\" type=\"submit\" onclick=\"send()\">Submit</button>" +
                "</body>\n" +
                "</html>";
    }

    @JsonIgnore
    public ModelAndView getNew() {
        return new ModelAndView("create");
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}

