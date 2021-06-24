import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class MainForDiablo {

    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";

    public static void main(String[] args) throws IOException {

        try {
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
                    connection.prepareStatement(
                            "SELECT first_name, last_name, count(game_id) AS count_of_games FROM diablo.users " +
                            "JOIN users_games ug on users.id = ug.user_id " +
                            "GROUP BY users.id");


            System.out.println("Username: " + user);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("first_name") + " " +
                        resultSet.getString("last_name") + " " + resultSet.getInt("count_of_games"));
            }


        } catch (SQLException sqlException) {
            System.out.println("No such user exists");
        }
    }
}
