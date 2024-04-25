import java.sql.Connection;

import dao.DatabaseUtils;

public class App {
    public static void main(String[] args) {
        Connection connection = DatabaseUtils.getConnection();
        System.out.println(connection);
    }
}
