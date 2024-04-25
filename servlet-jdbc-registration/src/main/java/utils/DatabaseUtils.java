package utils;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class DatabaseUtils {
    private final static String DATABASE_PROPERTIES_LOCATION = "database.properties";
    
    static Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Properties dbProps = new Properties();
            dbProps.load(DatabaseUtils.class.getClassLoader().getResourceAsStream(DATABASE_PROPERTIES_LOCATION));

            Class.forName(dbProps.getProperty("DRIVER_PATH"));

            connection =  DriverManager.getConnection(
                                dbProps.getProperty("JDBC_URL"), 
                                dbProps.getProperty("USERNAME"), 
                                dbProps.getProperty("PASSWORD")
                            );
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
            LOG.warning("Unable to find property file at location : " + DATABASE_PROPERTIES_LOCATION);
        }
        catch(SQLException e) {
            e.printStackTrace();
            LOG.warning("Unable to establish connection with database");
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
            LOG.warning("Unable to load jdbc driver ");
        }
        catch(Exception e) {
            e.printStackTrace();
            LOG.warning("Something went wrong");
        }

        return connection;
    }
    
}
