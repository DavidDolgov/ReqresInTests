package dto;

import org.aeonbits.owner.ConfigFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static final ConfigPostgres application = ConfigFactory.create(ConfigPostgres.class);
    private static final String url = application.url();
    private static final String user = application.user();
    private static final String password = application.password();

    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

}