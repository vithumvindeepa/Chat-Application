package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection {

    private static DbConnection dbConnection;
    private static Connection connection;


    private  DbConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chatapp","root","1234");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static DbConnection getInstance(){
        return (dbConnection == null) ? dbConnection = new DbConnection() : dbConnection;
    }

    public Connection getConnection(){
        if (connection==null){
            dbConnection=new DbConnection();

        }
        return connection;
    }
    public static ResultSet search(String query)throws Exception {
        if (connection == null) {
            new DbConnection();
        }

        return connection.createStatement().executeQuery(query);
    }



}
