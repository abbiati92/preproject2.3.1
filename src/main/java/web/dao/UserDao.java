package web.dao;

import web.model.Users;

import java.util.List;

public interface UserDao {
    List<Users> getAllUsers();
    void addUser(Users users);
    void changeUser();
    void deleteUser();
}
