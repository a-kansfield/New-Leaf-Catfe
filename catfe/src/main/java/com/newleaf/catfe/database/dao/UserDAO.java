package com.newleaf.catfe.database.dao;


import com.newleaf.catfe.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
}
