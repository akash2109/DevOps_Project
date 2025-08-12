package com.crud.service;

import com.crud.dao.UserDao;
import com.crud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDao userDao;

    public void save(User user) {
        userDao.save(user);
    }

    public User get(Long id) {
        return userDao.get(id);
    }

    public List<User> list() {
        return userDao.list();
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(Long id) {
        userDao.delete(id);
    }

    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }
}