package com.example.Code_Sharing_Platform.ManyToManyExample;

import lombok.*;
import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@ToString(exclude="peopleInContact")
@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String species;
    private String name;
    private boolean ruinsFurniture;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "animal_person",
            joinColumns = @JoinColumn(name = "animal_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    private Set<Person> peopleInContact = new LinkedHashSet<>();

    public Animal(String species, String name, boolean ruinsFurniture) {
        this.species = species;
        this.name = name;
        this.ruinsFurniture = ruinsFurniture;
    }
}