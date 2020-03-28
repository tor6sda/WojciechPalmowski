import util.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Przyklad4 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("?");
        String questionMark = ",?";
        int tablica[] = new int[]{1,3};

        for (int i = 1; i<tablica.length; i++){
            stringBuilder.append(questionMark);
        }

        String query = "Select * from category where cat_id in("+stringBuilder.toString()+")";

        try(PreparedStatement preparedStatement = DatabaseConnection.getInstance().getConnection().prepareStatement(query)){
            for (int i =0; i<tablica.length; i++){
                preparedStatement.setInt(i+1,tablica[i]);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("CAT_ID");
                String name = resultSet.getString("CAT_NAME");
                System.out.println("Cat ID: " +id+ " Cat Name: " + name);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
