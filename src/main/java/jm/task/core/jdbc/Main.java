package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserServiceImpl usi = new UserServiceImpl();
        usi.createUsersTable();
        usi.saveUser("Petr", "Petrov", (byte) 1);
        usi.saveUser("Ivan", "Sokolov", (byte) 23);
        usi.saveUser("Vlad", "Rebrov", (byte) 31);
        usi.saveUser("Ilya", "Brandt", (byte) 14);
        List<User> list = usi.getAllUsers();
        for (User us : list) {
            System.out.println(us.toString());
        }
        usi.cleanUsersTable();
        usi.dropUsersTable();
    }
}
