package com.mz.service4services.service;

import com.mz.service4services.dao.IUserDAO;
import com.mz.service4services.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements IUserService {

    private IUserDAO userDAO;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(IUserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findById(int id) {
        return userDAO.findById(id);
    }

    @Transactional
    @Override
    public User save(User user) {
        return userDAO.save(user);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        userDAO.deleteById(id);
    }

    @Override
    public User signUp(String email, String password, String firstname, String lastname) {
        if (userDAO.findByEmail(email) != null) {
            throw new RuntimeException("User with this email already exists");
        }

        String encodedPassword = passwordEncoder.encode(password);
        User newUser = new User(email,encodedPassword,firstname,lastname);
        return userDAO.save(newUser);
    }

    @Override
    public String signIn(String email, String password) {
        if (userDAO.findByEmail(email) == null) {
            throw new RuntimeException("User with this email does not exist");
        }

        User user = userDAO.findByEmail(email);
        if (passwordEncoder.matches(password, user.getPassword())) {
            return user.getEmail();
        } else {
            throw new RuntimeException("Wrong password");
        }
    }
}
