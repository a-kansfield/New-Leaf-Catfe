package com.newleaf.catfe.database.dao;

import com.newleaf.catfe.database.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatDAO extends JpaRepository<Cat, Long> {

    Cat findById(Integer id);

}
