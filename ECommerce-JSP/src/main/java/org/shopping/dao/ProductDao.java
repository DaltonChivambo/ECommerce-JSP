package org.shopping.dao;

import org.shopping.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String query;

    public ProductDao(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();


        try {
            query = "SELECT * FROM products";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setCategory(resultSet.getString("category"));
                product.setPrice(resultSet.getFloat("price"));
                product.setImage(resultSet.getString("image"));
                products.add(product);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return products;
    }
}
