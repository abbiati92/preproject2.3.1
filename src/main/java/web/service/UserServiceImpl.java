package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.Users;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<Users> getUsersList() {
        return userDao.getUsersList();
    }

    @Override
    public Users getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional
    public void addUser(Users user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public void editUser(Users user) {
        userDao.editUser(user);
    }
}
