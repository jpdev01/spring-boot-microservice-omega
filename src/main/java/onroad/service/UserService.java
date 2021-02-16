package onroad.service;

import onroad.dao.impl.UserDAOImpl;
import onroad.entity.User;

import java.util.Set;

public class UserService {

    private UserDAOImpl dao = new UserDAOImpl();

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
