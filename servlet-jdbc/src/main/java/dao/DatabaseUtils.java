package dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseUtils {
    // public static final String DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
    // public static final String USERNAME = "root";
    // public static final String PASSWORD = "";
    // public static final String JDBC_URL = "jdbc:mysql://localhost:3306/test";

    public static final String DB_PROPERTIES = "database.properties";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            // FileInputStream fis = new FileInputStream(DB_PROPERTIES);

            Properties databaseProperties = new Properties();
            databaseProperties.load(DatabaseUtils.class.getClassLoader().getResourceAsStream(DB_PROPERTIES));

            String DRIVER_PATH = databaseProperties.getProperty("DRIVER_PATH");
            String USERNAME = databaseProperties.getProperty("USERNAME");
            String PASSWORD = databaseProperties.getProperty("PASSWORD");
            String JDBC_URL = databaseProperties.getProperty("JDBC_URL");

            Class.forName(DRIVER_PATH);

            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (FileNotFoundException e) {
            System.err.println(DB_PROPERTIES + " file not found");
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            System.err.println("Failed to load jdbc driver");
            System.err.println(e);
        } catch (SQLException e) {
            System.err.println("Failed to establish the connection with database");
            System.err.println(e);
        } catch (Exception e) {
            System.err.println("Something went wrong");
            System.err.println(e);
        }

        return connection;
    }
}
