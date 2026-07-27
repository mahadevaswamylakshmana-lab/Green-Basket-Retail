package com.skybridge.greenbasket.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {

    private static String url;
    private static String username;
    private static String password;

    static {

        try {

            Properties properties = new Properties();

            InputStream inputStream = DBConnection.class.getClassLoader()
                    .getResourceAsStream("database.properties");

            if (inputStream == null) {
                throw new RuntimeException("database.properties file not found!");
            }

            properties.load(inputStream);

            url = properties.getProperty("db.url");
            username = properties.getProperty("db.username");
            password = properties.getProperty("db.password");

            System.out.println("======================================");
            System.out.println("Database Configuration Loaded");
            System.out.println("URL      : " + url);
            System.out.println("Username : " + username);
            System.out.println("======================================");

            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("MySQL JDBC Driver Loaded Successfully.");

        } catch (Exception e) {

            System.out.println("Error while loading database configuration.");
            e.printStackTrace();

            throw new RuntimeException(e);

        }

    }

    public static Connection getConnection() {

        try {

            System.out.println("Attempting database connection...");

            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Database Connected Successfully.");

            return con;

        } catch (Exception e) {

            System.out.println("Database Connection Failed!");
            System.out.println("URL      : " + url);
            System.out.println("Username : " + username);

            e.printStackTrace();

            throw new RuntimeException("Failed to connect to database.", e);

        }

    }

}