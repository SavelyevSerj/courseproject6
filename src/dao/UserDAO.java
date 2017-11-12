package dao;

import model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by BigBadVoodooDaddy on 07.11.2017.
 */
@Stateless
public class UserDAO {
    @PersistenceContext
    EntityManager entityManager;

    public User findUser(String id) {
        List<User> users = entityManager.createQuery("select u from User u").getResultList();
        return users.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    public List<User> findAll() {
        return entityManager.createQuery("select u from User u").getResultList();
    }
}
