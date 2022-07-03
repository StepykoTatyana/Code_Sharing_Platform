package com.example.Code_Sharing_Platform.ManyToManyExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ShelterCommandLineRunner implements CommandLineRunner {

    @Autowired
    EntityService entityService;

    @Override
    public void run(String... args) {
        entityService.insertEntities();
        //other EntityService methods
    }
}
