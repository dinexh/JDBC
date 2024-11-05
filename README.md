# Library System JDBC Project

## Overview
This is a Java-based Library System that performs CRUD (Create, Read, Update, Delete) operations on a MySQL database using JDBC. The system allows users to add, view, update, and delete books from the `Library` table.

## Database Overview

### Database: `JDBC`
- The project uses a MySQL database named `JDBC`.
- The system interacts with the `Library` table that stores book information.

### Table: `Library`

| Column Name | Data Type       | Constraints                        | Description                          |
|-------------|-----------------|------------------------------------|--------------------------------------|
| `id`        | `int`           | `PRIMARY KEY`, `AUTO_INCREMENT`, <br/>`NOT NULL` | Unique identifier for each book. |
| `title`     | `varchar(255)`  | `NULL`                             | Title of the book.                   |
| `author`    | `varchar(255)`  | `NULL`                             | Author of the book.                  |

---

## SQL Queries Used

-- 1. Insert a Book (Create)
    INSERT INTO Library (title, author) 
    VALUES (?, ?); -- title, author

-- 2. List All Books (Read)
    SELECT * FROM Library;

-- 3. Update a Book (Update)
    UPDATE Library 
    SET title = ?, author = ? -- title, author
    WHERE id = ?;  -- id

-- 4. Delete a Book (Delete)
    DELETE FROM Library 
    WHERE id = ?;  -- id

## Project Structure
LibrarySystem/
├── src/
│   ├── LibrarySystem.java       # Main application code with CRUD operations and interactive menu
│   ├── DatabaseConnection.java   # Manages MySQL database connection
│
├── lib/
│   └── mysql-connector-java.jar  # MySQL JDBC driver
│
├── build/
│   └── (Compiled .class files go here after compilation)
