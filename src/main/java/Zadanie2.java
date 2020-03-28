import util.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Zadanie2 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("?");
        String questionMark = ",?";
        int[] tablica = new int[]{1,3,5};

        for (int i=1; i<tablica.length; i++){
            stringBuilder.append(questionMark);
        }

        String query = "update product "+
                "set PRO_DESCRIPTION = CONCAT(PRO_DESCRIPTION, ?) "+
                "WHERE pro_id in ("+stringBuilder.toString()+")";
        try(PreparedStatement preStatement = DatabaseConnection.getInstance().getConnection().prepareStatement(query)){
            preStatement.setString(1, " - BRAK");
            for (int i=0; i<tablica.length; i++){
                preStatement.setInt(i+2, tablica[i]);
            }
            int count = preStatement.executeUpdate();
            System.out.println("Zaktualizowano "+count+" rekordow");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

