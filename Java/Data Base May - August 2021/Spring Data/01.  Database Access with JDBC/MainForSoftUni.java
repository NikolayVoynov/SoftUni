import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    private static final String DATABASE_NAME = "soft_uni";

    public static void main(String[] args) throws SQLException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter user name:");
        String user = reader.readLine();
        System.out.println("Enter password:");
        String password = reader.readLine();

        System.out.println("Enter database:");
        String database_name = reader.readLine();

        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection =
                DriverManager.getConnection(CONNECTION_STRING + database_name, properties);

        PreparedStatement preparedStatement =
                connection.prepareStatement( "SELECT first_name, last_name FROM soft_uni.employees WHERE salary > ?");
        System.out.println("Enter salary:");
        String salary = reader.readLine();
        preparedStatement.setDouble(1,Double.parseDouble(salary));

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("first_name") + " | " + resultSet.getString("last_name"));
        }

    }
}
