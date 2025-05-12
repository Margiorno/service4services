package com.mz.service4services.dao;

import com.mz.service4services.entity.User;

import java.util.List;

public interface IUserDAO {

    List<User> findAll();

    User findById(int id);

    User save(User user);

    void deleteById(int id);

    User findByEmail(String email);
}
