package bean;

import dao.UserDAO;
import model.User;

import javax.ejb.EJB;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by BigBadVoodooDaddy on 07.11.2017.
 */
@SessionScoped
@Named
public class UserBean implements Serializable{

    @EJB
    UserDAO userDAO;

    public List<User> getUserList() {
        return userDAO.findAll();
    }

}
