package jm.task.core.jdbc.util;
import java.sql.*;

public class Util {
    private Util() {
    }
    // реализуйте настройку соеденения с БД
    private static Connection connection;
    public static Connection getCon() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "29616895");
        }
        return connection;
    }
}

