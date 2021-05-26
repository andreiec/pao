package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBConnection {

    private Connection connection = null;

    private static final JDBConnection instance = new JDBConnection();

    private JDBConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = getConnection();
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pao", "root", "panda11022001");
    }

    public static JDBConnection getInstance() {
        return instance;
    }

    public Connection getDBConnection() {
        return this.connection;
    }
}