// src/DatabaseConnection.java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/JDBC"; // Database: JDBC
    private static final String USER = "karthik"; // MySQL username (change if different)
    private static final String PASSWORD = "asdfghjk"; // MySQL password (provide your password here)

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
