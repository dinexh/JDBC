package main;

import dao.BookDAO;
import models.Book;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementApp {
    public static void main(String[] args) {
        BookDAO bookDAO = new BookDAO();
        Scanner scanner = new Scanner(System.in);

        try {
            // Sample Operations
            System.out.println("Adding a new book...");
            bookDAO.addBook(new Book(0, "Effective Java", "Joshua Bloch", "Programming", 2008));

            System.out.println("Fetching all books...");
            List<Book> books = bookDAO.getAllBooks();
            for (Book book : books) {
                System.out.println(book.getTitle());
            }

            System.out.println("Updating a book...");
            Book bookToUpdate = books.get(0);
            bookToUpdate.setYearPublished(2018);
            bookDAO.updateBook(bookToUpdate);

            System.out.println("Deleting a book...");
            if (!books.isEmpty()) {
                bookDAO.deleteBook(books.get(0).getBookId());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
