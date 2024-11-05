package models;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private String genre;
    private int yearPublished;

    // Constructors, getters, and setters

    public Book(int bookId, String title, String author, String genre, int yearPublished) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.yearPublished = yearPublished;
    }

    // Getters and Setters
}
