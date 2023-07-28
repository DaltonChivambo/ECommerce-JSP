package org.shopping.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private String port;
    private String host;
    private String user;
    private String pass;
    private String database;

    public ConnectionDB() {
        this.port = "3306";
        this.host = "localhost";
        this.user = "root";
        this.pass = "";
        this.database = "ecommerce_cart";
    }

    public static Connection getConnection(){
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            ConnectionDB c = new ConnectionDB();
            connection = DriverManager.getConnection("jdbc:mysql://"+c.host+":"+c.port+"/"+c.database+"?useSSL=false",c.user,c.pass);
            System.out.println("Connected");
        }catch (SQLException e){
            e.printStackTrace();
        }

        return connection;
    }
}
