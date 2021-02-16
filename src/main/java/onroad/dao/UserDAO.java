package onroad.dao;

import onroad.entity.User;

import java.util.Set;

public interface UserDAO {

    public void save(User u);
    public User findById(Integer id);
    public Set<User> findAll();
    public void remove(Integer id);

}
