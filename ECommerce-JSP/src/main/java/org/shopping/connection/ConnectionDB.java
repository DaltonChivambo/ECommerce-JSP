package org.shopping.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private String porta;
    private String host;
    private String user;
    private String pass;
    private String database;

    public ConnectionDB() {
        this.porta = "3306";
        this.host = "localhost";
        this.user = "root";
        this.pass = "";
        this.database = "ecommerce_cart";
    }

    public Connection getConnection(){
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection("jdbc:mysql://"+host+":"+porta+"/"+database+"?useSSL=false",user,pass);
            System.out.println("Connected");
        }catch (SQLException e){
            e.printStackTrace();
        }

        return connection;
    }
}
