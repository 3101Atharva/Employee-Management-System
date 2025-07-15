package org.example;



import java.sql.*;
import java.util.concurrent.Executor;

/**
 * Hello world!
 *
 */
public class EmployeeManagement
{

    //jdbc basic cre
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/employee";
    private static final String USER_NAME="root";
    private static final String PASSWORD="Atharva@1616";


    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    public static void main( String[] args )
    {
        try {
            //making database connectivity
            connection = DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);

            //create table
            //createEmployeeTable();

            //insert data into table
            insertDataIntoDb("Avi",50,"avi@gmail.com");
            insertDataIntoDb("rahul",100,"rahul@gmail.com");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void insertDataIntoDb(String name, int age, String email) throws SQLException {
        String insertSQL = "INSERT INTO Employee (name,age,email) VALUES (? , ?, ?)";
        preparedStatement =connection.prepareStatement(insertSQL);
        preparedStatement.setString(1,name);
        preparedStatement.setInt(2,age);
        preparedStatement.setString(3,email);

        preparedStatement.executeUpdate();
        System.out.println("Data Inserted ....");

    }

    private static void createEmployeeTable() throws SQLException {

        String createTable="CREATE TABLE IF NOT EXISTS Employee ( id INT AUTO_INCREMENT PRIMARY KEY," +
                " name VARCHAR(100) ,"
                +"age INT ,"
                +"email VARCHAR(100)"
                +")";
        preparedStatement=connection.prepareStatement(createTable);
        preparedStatement.execute();
        System.out.println("Table created ....");

    }
}