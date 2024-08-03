package com.newleaf.catfe.service;

import com.newleaf.catfe.database.dao.UserDAO;
import com.newleaf.catfe.database.entity.User;
import com.newleaf.catfe.form.CreateAccountFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(CreateAccountFormBean form) {

        User user = new User();
        user.setEmail(form.getEmail());
        String encryptedPassword = passwordEncoder.encode(form.getPassword());
        user.setPassword(encryptedPassword);

        log.debug(user.toString());
        userDAO.save(user);

        return user;
    }

}
