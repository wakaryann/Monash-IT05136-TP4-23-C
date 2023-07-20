package src.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Driver {

    public static void main(String[] args) {
        // JDBC link provided
        String connectionString = "jdbc:sqlserver://teamc-jss.database.windows.net:1433;database=manage-jss-cloud;user=jss-admin-testing@teamc-jss;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

        // Connect to the database
        try (Connection connection = DriverManager.getConnection(connectionString)) {
            System.out.println("Connected to Azure database successfully!");

            // Now that you are connected, you can use the connection for database operations.

            // For example, let's create a simple query to retrieve some data from a table.
            // Replace 'employees' with the actual table name in your database.
            String sqlQuery = "SELECT * FROM dbo.tbl_DBT_User; GO";

            // Execute the query
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sqlQuery)) {

                // Process the query results
                while (resultSet.next()) {
                    // Assuming 'employees' table has 'name' and 'age' columns
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");

                    System.out.println("Name: " + name + ", Age: " + age);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

