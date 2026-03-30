package ro.uaic.info;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            GenreDAO genres = new GenreDAO();
            System.out.println("Se inserează genul...");
            genres.create("Action");
            genres.create("Drama");
            Integer actionId = genres.findByName("Action");
            System.out.println("Genul 'Action' are ID-ul: " + actionId);

            String name = genres.findById(actionId);
            System.out.println("Verificare: ID-ul " + actionId + " aparține genului: " + name);

            System.out.println("Test finalizat cu succes!");

        } catch (SQLException e) {
            System.err.println("Eroare SQL: " + e.getMessage());
        } finally {

            Database.closeConnection();
        }
    }
}