import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) {
        // JDBC link provided
        String connectionString = "jdbc:sqlserver://teamc-jss.database.windows.net:1433;database=manage-jss-cloud;user=jss-admin-testing@teamc-jss;password=TeamC-TP4-2023;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

        // Connect to the database
        try (Connection connection = DriverManager.getConnection(connectionString)) {
            System.out.println("Connected to Azure database successfully!");

            // Now that you are connected, you can use the connection for database operations.

            // For example, let's create a simple query to retrieve some data from 'dbo.tbl_dbt_User' table.
            String sqlQuery = "SELECT * FROM dbo.tbl_dbt_User";

            // Execute the query
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sqlQuery)) {

                // Process the query results
                while (resultSet.next()) {
                    // Print all columns from the result set
                    for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                        System.out.print(resultSet.getString(i) + "\t");
                    }
                    System.out.println();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
