package com.newleaf.catfe.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "event_users")
public class EventUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
        @JoinColumn(name = "user_id", nullable = true)
    private User user;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Integer userID;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
        @JoinColumn(name = "event_id", nullable = true)
    private Event event;

    @Column(name = "event_id", insertable = false, updatable = false)
    private Integer eventID;

    @Column(name = "adoption_interest")
    private String adoptionInterest;

}
