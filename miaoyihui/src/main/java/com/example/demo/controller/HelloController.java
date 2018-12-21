package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.UserService;
import com.example.demo.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@RestController
public class HelloController {
    UserService US = new UserService();
    User user = new User();
    @RequestMapping(value = "/Login")
    public User Login(String count, String password, HttpServletRequest request) throws ClassNotFoundException, SQLException {
        String role = "student";
        HttpSession session = request.getSession();
        user = US.Login(count,password,role);
        if(user != null) {
            session.setAttribute("User",user);
        }
        return user;
    }

    @RequestMapping(value="/Enroll")
    public String Enroll(String count,String password,String name,HttpServletRequest request) throws ClassNotFoundException,SQLException{
        String role = "student";
        HttpSession session = request.getSession();
        System.out.println(count+" "+password);
        String state = US.Enroll(count,password,name,role);
        if("success".equals(state)){
            user = US.Login(count,password,role);
            session.setAttribute("User",user);
        }
        return state;
    }

    @RequestMapping(value="/Home")
    public User Home(HttpServletRequest request){
        HttpSession session = request.getSession();
        System.out.println(user.getName());
        user = (User)session.getAttribute("User");
        return user;
    }
}
