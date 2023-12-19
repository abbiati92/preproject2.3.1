package web.service;

import org.springframework.stereotype.Component;
import web.dao.UserDao;

@Component
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public void addUser() {
        userDao.addUser();
    }

    @Override
    public void changeUser() {
        userDao.changeUser();
    }

    @Override
    public void deleteUser() {
        userDao.deleteUser();
    }
}
