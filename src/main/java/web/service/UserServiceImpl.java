package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.Users;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Users> getUsersList() {
        return userDao.getUsersList();
    }

    @Override
    @Transactional(readOnly = true)
    public Users getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    public void addUser(Users user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public void editUser(Users user) {
        userDao.editUser(user);
    }
}
