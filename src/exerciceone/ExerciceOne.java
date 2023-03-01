package exerciceone;

import database.DbConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ExerciceOne {
    public static void createTable() {
        final String SQL = """
                    CREATE TABLE company(
                        id SERIAL PRIMARY KEY NOT NULL,
                        name TEXT NOT NULL,
                        age INT NOT NULL,
                        address CHAR(50),
                        salary REAL
                    )
                """;

        try {
            Connection connection = new DbConnection().connect();
            Statement statement = connection.createStatement();
            statement.executeUpdate(SQL);
            System.out.println("Table created successfull");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static int updateTable() {
        final String request = """
                    UPDATE company
                    SET salary = 25000.00
                    WHERE id = 1
                """;
        int affectedRow = 0;
        try {
            Connection connection = new DbConnection().connect();
            Statement statement = connection.createStatement();
            affectedRow = statement.executeUpdate(request);

            if (affectedRow == 0) {
                System.out.println("Any data updated");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return affectedRow;
    }
}
