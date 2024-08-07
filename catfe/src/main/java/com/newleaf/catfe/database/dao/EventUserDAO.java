package com.newleaf.catfe.database.dao;

import com.newleaf.catfe.database.entity.EventUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventUserDAO extends JpaRepository<EventUser, Long> {

    @Query("SELECT eu.userID FROM EventUser eu WHERE eu.adoptionInterest = :adoptionInterest")
    EventUser findByAdoptionInterest(String adoptionInterest);
}
