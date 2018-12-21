package com.example.demo.dao;

import java.sql.*;

import com.example.demo.util.DBHelper;
import com.example.demo.model.User;

public class UserDao {

    public User Login(String count,String password,String role) throws ClassNotFoundException,SQLException{
        Connection con = DBHelper.ConnectionDB();
        User user = new User();
        if(con != null){
            PreparedStatement ps = con.prepareStatement("select * from user where Usercount = ? and password = ? and role = ?");
            ps.setString(1,count);
            ps.setString(2,password);
            ps.setString(3,role);
            ResultSet rs = ps.executeQuery();
            String Usercount = null;
            String Userpass = null;
            String Userrole = null;
            String name = null;
            while (rs.next()) {
                Usercount = rs.getString("Usercount");
                Userpass = rs.getString("password");
                name = rs.getString("name");
                Userrole = rs.getString("role");
                System.out.println(Usercount+" "+Userpass+" "+name+" "+Userrole);
                user.setCount(Usercount);
                user.setName(name);
                user.setPassword(Userpass);
                user.setRole(Userrole);

            }

        }
        return user;
    }

    public String Enroll(String count,String password,String name,String role) throws ClassNotFoundException,SQLException{
        Connection con = DBHelper.ConnectionDB();
        if(con != null){
            if(isExited(count)){
                return "isExited";
            }
            PreparedStatement ps = con.prepareStatement("insert into User values (?,?,?,?)");
            ps.setString(1,count);
            ps.setString(2,name);
            ps.setString(3,password);
            ps.setString(4,role);
            int rs = ps.executeUpdate();
            if(rs == 1){
                System.out.println(count+" "+role);
                return "success";
            }
        }
        return "failed";
    }
    public boolean isExited(String count) throws ClassNotFoundException,SQLException{//存在返回true，不存在返回false
        Connection con = DBHelper.ConnectionDB();
        if(con != null){
            PreparedStatement ps = con.prepareStatement("select * from User where Usercount = ?");
            ps.setString(1,count);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        }
        return false;
    }
}
