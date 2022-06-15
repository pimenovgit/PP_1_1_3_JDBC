package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() throws SQLException {
        Util.connection.createStatement().executeUpdate("DROP TABLE IF EXISTS Users;");
        System.out.println("Таблица удалена");
    }

    public void dropUsersTable() throws SQLException {
        Util.connection.createStatement().executeUpdate("DROP TABLE IF EXISTS Users;");
        System.out.println("Таблица удалена");
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        PreparedStatement preparedStatement = Util.connection.prepareStatement("INSERT INTO Users (firstname, lastname, age) VALUES (?, ?, ?)");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, lastName);
        preparedStatement.setByte(3, age);
        preparedStatement.executeUpdate();
        System.out.println("User с именем " + name + " добавлен в базу данных");
    }

    public void removeUserById(long id) throws SQLException {
        PreparedStatement preparedStatement = Util.connection.prepareStatement("DELETE FROM Users WHERE id = ?");
        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();
        System.out.println("Запись удалена");
    }

    public List<User> getAllUsers() throws SQLException {
        List <User> list = new ArrayList<>();
        ResultSet rs = Util.connection.createStatement().executeQuery("SELECT * FROM Users");
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getLong(1));
            user.setName(rs.getString(2));
            user.setLastName(rs.getString(3));
            user.setAge(rs.getByte(4));
            list.add(user);
        }
        return list;
    }

    public void cleanUsersTable() throws SQLException {
        ResultSet rs = Util.connection.createStatement().executeQuery("SELECT COUNT(id) as count FROM users");
        rs.next();
        if (rs.getInt("count") == 0) {
            System.out.println("В таблице нет значений");
        } else {
            Util.connection.createStatement().executeUpdate("DELETE FROM Users");
            System.out.println("Таблица очищена");
        }
    }
}
