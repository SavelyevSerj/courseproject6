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
}
