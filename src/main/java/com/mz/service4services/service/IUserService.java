package com.mz.service4services.service;

import com.mz.service4services.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findById(int id);

    User save(User user);

    void deleteById(int id);
}
