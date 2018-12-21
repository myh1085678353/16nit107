package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;

import java.sql.SQLException;

public class UserService {
    UserDao userDao = new UserDao();
    public User Login(String count,String password,String role) throws ClassNotFoundException, SQLException {
        return userDao.Login(count,password,role);
    }
    public String Enroll(String count,String password,String name,String role) throws ClassNotFoundException,SQLException{
        return userDao.Enroll(count,password,name,role);
    }
}
