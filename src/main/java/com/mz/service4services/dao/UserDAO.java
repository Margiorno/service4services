package com.mz.service4services.dao;

import com.mz.service4services.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDAO implements IUserDAO {

    private EntityManager entityManager;

    @Autowired
    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User findByEmail(String email) {
        try {
            TypedQuery<User> query = entityManager.createQuery(
                    "SELECT u FROM User u WHERE u.email = :email", User.class);
            return query.setParameter("email", email).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }


    @Override
    public List<User> findAll() {

        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);

        return query.getResultList();
    }

    @Override
    public User findById(int id) {

        User user = entityManager.find(User.class, id);

        return user;
    }

    @Override
    @Transactional
    public User save(User user) {

        User dbUser = entityManager.merge(user);

        return dbUser;
    }

    @Override
    public void deleteById(int id) {

        User user = entityManager.find(User.class, id);

        entityManager.remove(user);
    }
}
