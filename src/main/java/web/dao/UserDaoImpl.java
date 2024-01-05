package web.dao;


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
    public List<Users> getUsersList() {
        return entityManager.createQuery("SELECT u FROM Users u",Users.class).getResultList();
    }

    @Override
    public Users getUser(int id) {
        return entityManager.find(Users.class, id);
    }

    @Override
    public void addUser(Users user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(entityManager.find(Users.class,id));
    }

    @Override
    public void editUser(Users user) {
        entityManager.merge(user);
    }
}
