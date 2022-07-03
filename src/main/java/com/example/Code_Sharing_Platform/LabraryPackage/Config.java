package com.example.Code_Sharing_Platform.LabraryPackage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
class Config {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public TechLibrary2 library() {
        return new TechLibrary2();
    }
}

class TechLibrary2 {
    private final List<String> bookTitles =
            Collections.synchronizedList(new ArrayList<>());

    public void init() {
        bookTitles.add("Clean Code");
        bookTitles.add("The Art of Computer Programming");
        bookTitles.add("Introduction to Algorithms");
        System.out.println("The library has been initialized: " + bookTitles);
    }

    public void destroy() {
        bookTitles.clear();
        System.out.println("The library has been cleaned: " + bookTitles);
    }
}