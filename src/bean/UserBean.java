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

    User user = new User();

    User tmpUser = new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getTmpUser() {
        return tmpUser;
    }

    public void setTmpUser(User tmpUser) {
        this.tmpUser = tmpUser;
    }

    /**
     * @return String - поверає сторінку для користувача відповідну до його позиції
     */
    public String userChecking() {
        User foundUser = userDAO.findUser(this.user.getId());
        if (foundUser == null || !foundUser.getPassword().equals(user.getPassword())) return "error";
        else {
            user = foundUser;
            return foundUser.getPosition();
        }
    }


    public List<User> getUserList() {
        return userDAO.findAll();
    }

}
