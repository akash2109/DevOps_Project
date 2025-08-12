package com.crud.dao;

import com.crud.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public User get(Long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    public List<User> list() {
        return sessionFactory.getCurrentSession().createQuery("from User", User.class).list();
    }

    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    public void delete(Long id) {
        User user = get(id);
        if (user != null) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    public User findByEmail(String email) {
        Query<User> query = sessionFactory.getCurrentSession().createQuery("from User where email = :email", User.class);
        query.setParameter("email", email);
        return query.uniqueResult();
    }

    public User getUserByUsername(String username) {
        Query<User> query = sessionFactory.getCurrentSession().createQuery("from User where username = :username", User.class);
        query.setParameter("username", username);
        return query.uniqueResult();
    }
}
