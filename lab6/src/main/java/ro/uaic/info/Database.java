package ro.uaic.info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Connection connection = null;

    private Database() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                String url = "jdbc:postgresql://localhost:5432/movies_db";
                String user = "postgres";
                String password = "your_password";
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.err.println("Eroare la conexiune: " + e.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}