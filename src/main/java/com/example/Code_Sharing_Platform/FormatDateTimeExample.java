package com.example.Code_Sharing_Platform;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatDateTimeExample {
    private static final String DATE_FORMATTER= "yyyy-MM-dd HH:mm:ss";

    public static String getDate() {

        LocalDateTime localDateTime = LocalDateTime.now(); //get current date time
        System.out.println("Current Time " + localDateTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);

        return localDateTime.format(formatter);

    }
}
