package onroad.service;

import onroad.dao.UserDAO;
import onroad.entity.User;

import java.util.List;
import java.util.Set;

public class UserService {

    private UserDAO dao = new UserDAO();

    public Set<User> loadAll()
    {
        return dao.findAll();
    }

    public User load(Integer id)
    {
        User user = dao.findById(id);
        return user;
    }

    public void remove(Integer id)
    {
        dao.remove(id);
    }

}
