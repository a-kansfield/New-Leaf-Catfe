package com.newleaf.catfe.database.dao;

import com.newleaf.catfe.database.entity.Cat;
import com.newleaf.catfe.database.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface EventDAO extends JpaRepository<Event, Long> {
    Event findById(Integer id);

List<Event> findByCat(Cat cat);

    @Query(value="SELECT e.*, c.name, c.description AS cat_description, c.image_url AS cat_image_url"
            +   " FROM events e "
            +   " JOIN cats c ON c.id = e.featured_cat "
            +   " WHERE e.id = :id;", nativeQuery = true)
    Map<String,Object> getEventDetails(Integer id);
}
