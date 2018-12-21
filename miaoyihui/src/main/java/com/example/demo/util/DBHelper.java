package com.example.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper{
    static final String DB_URL = "jdbc:mysql://localhost:3306/nit107";
    static final String DRIVER = "com.mysql.jdbc.Driver";
    static final String USER = "root";
    static final String PASS = "184429";

    public static Connection ConnectionDB() throws ClassNotFoundException,SQLException{
        Connection conn = null;
        Class.forName(DRIVER);
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        if(!conn.isClosed()){
            System.out.println("数据库连接成功！");
        }
        return conn;
    }
}
