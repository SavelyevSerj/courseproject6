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
        List resultList = entityManager.createQuery("select u from User u").getResultList();
        List<User> userList = resultList;
        return userList.stream().filter(e -> e.getLogin().equals(login)).findFirst().orElse(null);
    }

    public void add(User user) {
        entityManager.persist(user);
    }

    public void delete(User user) {
        entityManager.remove(user);
    }

//    public void refresh(List<User> users) {
//        entityManager.flush(users);
//    }
}
