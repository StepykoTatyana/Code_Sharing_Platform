package com.example.Code_Sharing_Platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CodesService {
    @Autowired
    CodesRepository repository;
    public CodesRepository getRepository() {
        return repository;
    }

    public void setRepository(CodesRepository repository) {
        this.repository = repository;
    }

    public List<Snippets> getAllRecipes() {
        List<Snippets> recipes = new ArrayList<Snippets>();
        for (Snippets recipes2 : repository.findAll()) {
            recipes.add(recipes2);
        }
        return recipes;
    }


    public ResponseEntity<?> getCodePageByUuid(String uuid) {
        try {
            Snippets snippets = repository.findByUUID(uuid);
            return new ResponseEntity<>(snippets, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public void saveToRepository(String code, String date) {
        repository.save(new Snippets(code, date));
    }
}
