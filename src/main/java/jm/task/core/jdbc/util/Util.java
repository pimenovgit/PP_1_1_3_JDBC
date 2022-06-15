package jm.task.core.jdbc.util;
import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД
    public static Connection connection;

    static {
        try {
            connection = getCon();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getCon() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "29616895");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

