package onroad.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private String password;
    private String permission;

    public User(){}

    public User(String login, String password, String permission) {
        this.setLogin(login);
        this.setPassword(password);
        this.setPermission(permission);
    }

    public User(Integer id, String login, String password, String permission) {
        this.setId(id);
        this.setLogin(login);
        this.setPassword(password);
        this.setPermission(permission);
    }

    public User(Integer id, String login, String password) {
        this.setId(id);
        this.setLogin(login);
        this.setPassword(password);
        this.setPermission("low");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
