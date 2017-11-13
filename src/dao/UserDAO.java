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

    public List<User> findAll() {
        return entityManager.createQuery("select u from User u").getResultList();
    }

    public User findUser(String login) {
        List<User> userList = findAll();
        return userList.stream().filter(e -> e.getLogin().equals(login)).findFirst().orElse(null);
    }
}
