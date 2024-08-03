package com.newleaf.catfe.database.dao;

import com.newleaf.catfe.database.entity.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface UserRoleDAO extends JpaRepository<UserRole, Long> {

    List<UserRole> findByUserId(Integer userId);

}
