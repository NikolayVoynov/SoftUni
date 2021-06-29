import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;

public class Main {

    public static final String CONNECTION_PATH = "jdbc:mysql://localhost:3306/";
    public static final String DATABASE = "minions_db";
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Connection connection;

    public static void main(String[] args) throws IOException, SQLException {
        connection = getConnection();

        System.out.println("Enter exercise number:");
        int exerciseNumber = Integer.parseInt(reader.readLine());

        switch (exerciseNumber) {
            case 2 -> exerciseTwo();
            case 3 -> exerciseThree();
            case 4 -> exerciseFour();
            case 5 -> exerciseFive();
            case 6 -> exerciseSix();
            case 7 -> exerciseSeven();
            case 8 -> exerciseEight();
            case 9 -> exerciseNine();
        }

    }

    private static void exerciseTwo() throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement(
                        "SELECT v.name, count(DISTINCT mv.minion_id) AS number_of_minions FROM villains AS v " +
                                "JOIN minions_villains mv on v.id = mv.villain_id " +
                                "GROUP BY villain_id " +
                                "HAVING number_of_minions > ? " +
                                "ORDER BY number_of_minions DESC;");

        preparedStatement.setInt(1, 15);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %d %n", resultSet.getString(1), resultSet.getInt(2));
        }
    }

    private static void exerciseThree() throws IOException, SQLException {
        System.out.println("Enter villain id:");
        int villainId = Integer.parseInt(reader.readLine());

        List<Integer> listOfVillainsId = findIdOfAllVillains();

        if (listOfVillainsId.contains(villainId)) {
            String villainName = findEntityNameByGivenId("villains", villainId);

            List<String> listOfAllMinionsByVillainId = getListOfAllMinionsByVillainId(villainId);

            System.out.printf("Villain: %s%n", villainName);
            for (String minion : listOfAllMinionsByVillainId) {
                System.out.println(minion);
            }
        } else {
            System.out.printf("No villain with ID %d exists in the database.", villainId);
        }
    }

    private static void exerciseFour() throws IOException, SQLException {
        System.out.println("Enter info for minion and villain:");

        String[] minionInfo = reader.readLine().split("\\s+");
        String[] villainInfo = reader.readLine().split("\\s+");

        String minionName = minionInfo[1];
        int minionAge = Integer.parseInt(minionInfo[2]);
        String minionTown = minionInfo[3];

        String villainName = villainInfo[1];

        Map<String, Integer> mapOfAllTowns = extractAllEntitiesNameAndIdFromTable("towns");

        if (!mapOfAllTowns.containsKey(minionTown)) {
            System.out.printf("Town %s was added to the database.%n", minionTown);

            PreparedStatement preparedStatementAddTown =
                    connection.prepareStatement("INSERT INTO towns(name) VALUES (?);");
            preparedStatementAddTown.setString(1, minionTown);

            preparedStatementAddTown.execute();
        }

        Map<String, Integer> mapOfAllVillains = extractAllEntitiesNameAndIdFromTable("villains");

        if (!mapOfAllVillains.containsKey(villainName)) {
            System.out.printf("Villain %s was added to the database.%n", villainName);

            PreparedStatement preparedStatementAddVillain =
                    connection.prepareStatement("INSERT INTO villains (name, evilness_factor) VALUES (?, ?);");
            preparedStatementAddVillain.setString(1, villainName);
            preparedStatementAddVillain.setString(2, "evil");

            preparedStatementAddVillain.execute();
        }

        mapOfAllTowns = extractAllEntitiesNameAndIdFromTable("towns");
        int idOfMinionTown = mapOfAllTowns.get(minionTown);
        PreparedStatement preparedStatementAddMinion =
                connection.prepareStatement("INSERT INTO minions (name,age, town_id) VALUES (?, ?, ?)");
        preparedStatementAddMinion.setString(1, minionName);
        preparedStatementAddMinion.setInt(2, minionAge);
        preparedStatementAddMinion.setInt(3, idOfMinionTown);

        preparedStatementAddMinion.execute();


        mapOfAllVillains = extractAllEntitiesNameAndIdFromTable("villains");
        int villainIdForThisMinion = mapOfAllVillains.get(villainName);

        Map<String,Integer> mapOfAllMinions = extractAllEntitiesNameAndIdFromTable("minions");
        int minionId = mapOfAllMinions.get(minionName);

        PreparedStatement preparedStatementSetNewMinionToBeServant =
                connection.prepareStatement("INSERT INTO minions_villains (minion_id, villain_id) VALUES (?, ?)");
        preparedStatementSetNewMinionToBeServant.setInt(1, minionId);
        preparedStatementSetNewMinionToBeServant.setInt(2, villainIdForThisMinion);

        preparedStatementSetNewMinionToBeServant.execute();

        System.out.printf("Successfully added %s to be minion of %s.%n", minionName, villainName);
    }

    private static void exerciseFive() throws IOException, SQLException {
        System.out.println("Enter country:");
        String countryName = reader.readLine();

        PreparedStatement preparedStatement =
                connection.prepareStatement(
                        "UPDATE towns " +
                                "SET name = UPPER(name) " +
                                "WHERE country LIKE ?;");

        preparedStatement.setString(1, countryName);

        int affectedTowns = preparedStatement.executeUpdate();

        if (affectedTowns == 0) {
            System.out.println("No town names were affected.");
            return;
        }

        PreparedStatement preparedStatementAffectedTowns =
                connection.prepareStatement("SELECT name FROM towns WHERE country LIKE ?");

        preparedStatementAffectedTowns.setString(1, countryName);

        ResultSet resultSet = preparedStatementAffectedTowns.executeQuery();

        List<String> listOfAffectedTowns = new ArrayList<>();

        while (resultSet.next()) {
            listOfAffectedTowns.add(resultSet.getString("name"));
        }

        System.out.printf("%d town names were affected.%n", affectedTowns);
        System.out.println(listOfAffectedTowns);
    }

    private static void exerciseSix() throws IOException, SQLException {
        System.out.println("Enter villain id:");
        int villainId = Integer.parseInt(reader.readLine());

        Map<String, Integer> allVillains = extractAllEntitiesNameAndIdFromTable("villains");
        if (!allVillains.containsValue(villainId)) {
            System.out.println("No such villain was found");
        } else {
            int affectedMinions = deleteMinionsByVillainId(villainId);
            String villainName = findEntityNameByGivenId("villains", villainId);

            deleteVillainByGivenId(villainId);

            System.out.printf("%s was deleted%n" + "%d minions released%n", villainName, affectedMinions);
        }
    }

    private static void exerciseSeven() throws SQLException {

        List<String> allMinions = new ArrayList<>();

        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT name FROM minions");

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            allMinions.add(resultSet.getString("name"));
        }

        int firstIndex = 0;
        int lastIndex = allMinions.size() - 1;

        for (int i = 0; i < allMinions.size(); i++) {
            System.out.println(i % 2 == 0 ? allMinions.get(firstIndex++) : allMinions.get(lastIndex--));
        }
    }

    private static void exerciseEight() throws IOException, SQLException {
        System.out.println("Enter minions id");
        int[] arrayMinionsId = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int idMinion : arrayMinionsId) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE minions " +
                            "SET name = LOWER (name), age = age + 1 " +
                            "WHERE id = ?");
            preparedStatement.setInt(1, idMinion);

            preparedStatement.executeUpdate();
        }

        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT name, age FROM minions");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %d%n", resultSet.getString("name"), resultSet.getInt("age"));
        }
    }

    private static void exerciseNine() throws IOException, SQLException {
        System.out.println("Enter minion id:");

        int minionId = Integer.parseInt(reader.readLine());

        CallableStatement callableStatement =
                connection.prepareCall("CALL usp_get_older(?)");
        callableStatement.setInt(1,minionId);

        callableStatement.executeUpdate();

        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT name, age FROM minions WHERE id = ?");
        preparedStatement.setInt(1,minionId);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %d%n", resultSet.getString("name"), resultSet.getInt("age"));
        }
    }

    private static Connection getConnection() throws IOException, SQLException {
        System.out.println("Enter user:");
        String user = reader.readLine();
        System.out.println("Enter pass:");
        String password = reader.readLine();

        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        return DriverManager.getConnection(CONNECTION_PATH + DATABASE, properties);
    }

    private static void deleteVillainByGivenId(int villainId) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("DELETE FROM villains WHERE id = ?");
        preparedStatement.setInt(1, villainId);

        preparedStatement.executeUpdate();
    }

    private static String findEntityNameByGivenId(String tableName, int entityId) throws SQLException {
        String query = String.format("SELECT name FROM %s WHERE id = ?", tableName);
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1, entityId);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString("name");
    }

    private static List<Integer> findIdOfAllVillains() throws SQLException {
        List<Integer> idOfAllVillains = new ArrayList<>();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM villains");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            idOfAllVillains.add(resultSet.getInt(1));
        }

        return idOfAllVillains;
    }

    private static Map<String, Integer> extractAllEntitiesNameAndIdFromTable(String tableName) throws SQLException {
        Map<String, Integer> mapOfAllEntities = new HashMap<>();

        PreparedStatement preparedStatementAllEntities = connection.prepareStatement("SELECT id, name FROM " + tableName);
        ResultSet resultSet = preparedStatementAllEntities.executeQuery();

        while (resultSet.next()) {
            mapOfAllEntities.put(resultSet.getString("name"), resultSet.getInt("id"));
        }

        return mapOfAllEntities;
    }

    private static List<String> getListOfAllMinionsByVillainId(int villainId) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement(
                        "SELECT m.name, m.age FROM villains v " +
                                "JOIN minions_villains mv on v.id = mv.villain_id " +
                                "JOIN minions m on m.id = mv.minion_id " +
                                "WHERE v.id = ?;");

        preparedStatement.setInt(1, villainId);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<String> listOfMinions = new ArrayList<>();

        int count = 1;

        while (resultSet.next()) {

            String minionInfo = String.format("%d. %s %d",
                    count++, resultSet.getString(1), resultSet.getInt(2));
            listOfMinions.add(minionInfo);
        }

        return listOfMinions;
    }

    private static int deleteMinionsByVillainId(int id) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("DELETE FROM minions_villains WHERE villain_id = ?");
        preparedStatement.setInt(1, id);

        return preparedStatement.executeUpdate();
    }
}
