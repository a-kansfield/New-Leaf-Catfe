package com.newleaf.catfe.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "cats")
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "adoption_status")
    private String adoptionStatus;

    @Column(name = "gender")
    private String gender;

    @Column(name = "image_url")
    private String imageURL;

    @Column(name = "adopted_by")
    private Integer adoptedBy;

    //One cat can feature in many events.
    @ToString.Exclude
    @OneToMany(mappedBy = "cat", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Event> events;

}