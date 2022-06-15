package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoJDBCImpl udjdbc = new UserDaoJDBCImpl();
    public void createUsersTable() throws SQLException {
        udjdbc.createUsersTable();
    }

    public void dropUsersTable() throws SQLException {
        udjdbc.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        udjdbc.saveUser(name,lastName,age);
    }

    public void removeUserById(long id) throws SQLException {
        udjdbc.removeUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
       return udjdbc.getAllUsers();
    }

    public void cleanUsersTable() throws SQLException {
        udjdbc.cleanUsersTable();
    }
}
