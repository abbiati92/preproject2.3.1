package web.service;

import web.model.Users;

import java.util.List;

public interface UserService {
    List<Users> getUsersList();
    Users getUser(int id);
    void addUser(Users user);
    void deleteUser(int id);
    void editUser(Users user);

}
