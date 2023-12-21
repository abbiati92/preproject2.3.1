package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.Users;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Users> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM Users u", Users.class).getResultList();
    }

    @Override
    public void addUser(Users users) {
        entityManager.merge(users);
    }

    @Override
    public void editUser(int id, Users updateUsers) {
        Users users = entityManager.find(Users.class, id);
        if (users != null) {
            users.setName(updateUsers.getName());
            users.setAge(updateUsers.getAge());
            entityManager.merge(users);
        }
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(entityManager.find(Users.class,id));
    }
    @Override
    public Users getUserById(int id) {
        return entityManager.find(Users.class,id);
    }
}
