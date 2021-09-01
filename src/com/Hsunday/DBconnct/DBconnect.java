package com.Hsunday.DBconnct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {
    String URL = "jdbc:mysql://localhost:3306/students?serverTimezone=GMT%2b8&useUnicode=true&characterEncoding=utf8&useSSL=true";
    String user = "root";
    String password = "admin";

    static {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库连接成功");
        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public Connection getConnect() throws SQLException{
        return DriverManager.getConnection(URL,user,password);
    }
}
