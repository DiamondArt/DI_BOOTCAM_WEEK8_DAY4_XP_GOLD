package exercicetwo;

import database.DbConnection;
import entities.Company;
import java.sql.*;
import java.util.List;

public class ExerciceTwo {
    public static void insertTable(List<Company> companies) {
        final String SQL = """
                    INSERT INTO company(id, name, age, address, salary)
                    VALUES(?, ?, ?, ?, ?)
                """;

        try {
            Connection connection = new DbConnection().connect();
            PreparedStatement statement = connection.prepareStatement(SQL);
            int count = 0;

            for (Company company : companies) {
                statement.setInt(1, company.getId());
                statement.setString(2, company.getName());
                statement.setInt(3, company.getAge());
                statement.setString(4, company.getAddress());
                statement.setDouble(5, company.getSalary());

                statement.addBatch();
                count++;
                if (count == companies.size()) {
                    statement.executeBatch();
                }
            }
            System.out.println("data inserted successfull");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int deleteTable() {
        final String request = """
                    DELETE FROM company
                    WHERE id = 2
                """;
        int affectedRow = 0;

        try {
            Connection connection = new DbConnection().connect();
            Statement statement = connection.createStatement();
            affectedRow = statement.executeUpdate(request);

            if (affectedRow == 0) {
                System.out.println("Any data deleted");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return affectedRow;
    }
}
