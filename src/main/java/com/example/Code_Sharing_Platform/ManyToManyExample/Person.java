package com.example.Code_Sharing_Platform.ManyToManyExample;

import lombok.*;
import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@ToString(exclude="animalsInContact")
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int freeHours;

    @ManyToMany(mappedBy = "peopleInContact")
    private Set<Animal> animalsInContact = new LinkedHashSet<>();

    public Person(String name, int freeHours) {
        this.name = name;
        this.freeHours = freeHours;
    }
}