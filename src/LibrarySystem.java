// src/LibrarySystem.java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LibrarySystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nLibrary System");
            System.out.println("1. Add a Book");
            System.out.println("2. List all Books");
            System.out.println("3. Update a Book");
            System.out.println("4. Delete a Book");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
//            scanner.nextLine();
            System.out.println("");

            switch (choice) {
                case 1:
                    System.out.println("Enter book title: ");
                    String title = scanner.nextLine();

                    System.out.println("Enter book author: ");
                    String author = scanner.nextLine();

                    addBook(title, author);
                    break;

                case 2:
                    listBooks();
                    break;

                case 3:
                    System.out.println("Enter the ID of the book to update: ");
                    int bookIdToUpdate = scanner.nextInt();
//                    scanner.nextLine();

                    System.out.println("Enter new title: ");
                    String newTitle = scanner.nextLine();

                    System.out.println("Enter new author: ");
                    String newAuthor = scanner.nextLine();

                    updateBook(bookIdToUpdate, newTitle, newAuthor);
                    break;

                case 4:
                    System.out.println("Enter the ID of the book to delete: ");
                    int bookIdToDelete = scanner.nextInt();
                    deleteBook(bookIdToDelete);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    public static void addBook(String title, String author) {
        String query = "INSERT INTO Library (title, author) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, title);
            stmt.setString(2, author);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Book added successfully.");
            } else {
                System.out.println("Failed to add the book.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listBooks() {
        String query = "SELECT * FROM Library";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("ID | Title | Author");
            System.out.println("---------------------");
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");

                System.out.println(id + " | " + title + " | " + author);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateBook(int bookId, String newTitle, String newAuthor) {
        String query = "UPDATE Library SET title = ?, author = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, newTitle);
            stmt.setString(2, newAuthor);
            stmt.setInt(3, bookId);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Book updated successfully.");
            } else {
                System.out.println("Failed to update the book.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteBook(int bookId) {
        String query = "DELETE FROM Library WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, bookId);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Book deleted successfully.");
            } else {
                System.out.println("Book not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
