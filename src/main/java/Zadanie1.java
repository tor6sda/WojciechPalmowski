import java.sql.*;

public class Zadanie1 {
        public static void main(String[] args) {
            String url = "jdbc:mysql://localhost:3306/shop?serverTimezone=CET";
            String user = "root";
            String password = "test";
            String query = "SELECT * FROM shop.user;";
            try (Connection connection = DriverManager.getConnection(url, user, password);
                 Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    System.out.println("First Name: " + resultSet.getString("USR_FIRSTNAME"));
                    System.out.println("Last Name " + resultSet.getString("USR_LASTNAME"));
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }

