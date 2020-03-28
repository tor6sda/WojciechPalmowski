import java.sql.*;

public class Przyklad2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/shop?serverTimezone=CET";
        String user = "root";
        String password = "test";
        String query = "Select * from address where add_city like \"%\"?\"%\";";
        try (
                Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preStatement = connection.prepareStatement(query)) {

            preStatement.setString(1,"Paris");
            ResultSet resultSet = preStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("add_id");
                String street = resultSet.getString("ADD_STREET");
                String city = resultSet.getString("ADD_CITY");
                System.out.println("Adress  id: " +id+ " Adress street: " + " Adress City: ");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
