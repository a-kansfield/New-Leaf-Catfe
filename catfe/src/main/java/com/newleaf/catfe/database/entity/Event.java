package com.newleaf.catfe.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "start_date", columnDefinition = "DATETIME")
    private Date startDate;

    @Column(name = "end_date", columnDefinition = "DATETIME")
    private Date endDate;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "serves_alcohol", columnDefinition = "TINYINT")
    private boolean servesAlcohol;

    @Column(name = "image_url")
    private String imageURL;


    // Foreign Key: Mapped to cat.id
    @Column(name = "featured_cat", insertable = false, updatable = false)
    private Integer featuredCat;

    // An event can only feature one cat.
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
        @JoinColumn(name = "featured_cat", nullable = true)
    private Cat cat;

    @ToString.Exclude
    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<EventUser> eventUsers;
}
