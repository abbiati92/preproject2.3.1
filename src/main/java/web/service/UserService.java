package web.service;

import web.model.Users;

import java.util.List;

public interface UserService {
    void addUser(Users users);
    List<Users> getAllUsers();
    void changeUser();
    void deleteUser();


}
