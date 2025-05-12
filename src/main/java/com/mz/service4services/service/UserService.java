package com.mz.service4services.service;

import com.mz.service4services.dao.IUserDAO;
import com.mz.service4services.entity.User;
import com.mz.service4services.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class UserService implements IUserService {

    private IUserDAO userDAO;
    private PasswordEncoder passwordEncoder;
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    public UserService(IUserDAO userDAO, PasswordEncoder passwordEncoder, JwtTokenUtil jwtTokenUtil) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenUtil = jwtTokenUtil;
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
    public Map<String, String> signIn(String email, String password) {
        User user = userDAO.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("User with this email does not exist");
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Wrong password");
        }

        String accessToken = jwtTokenUtil.generateAccessToken(user.getId());
        String refreshToken = jwtTokenUtil.generateRefreshToken(user.getId());

        return Map.of(
                "access_token", accessToken,
                "refresh_token", refreshToken
        );
    }
}
