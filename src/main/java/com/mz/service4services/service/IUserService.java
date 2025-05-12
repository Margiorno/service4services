package com.mz.service4services.service;

import com.mz.service4services.entity.User;

import java.util.List;
import java.util.Map;

public interface IUserService {
    List<User> findAll();

    User findById(int id);

    User save(User user);

    void deleteById(int id);

    User signUp(String email, String password, String firstname, String lastname);

    Map<String, String> signIn(String email, String password);
}
