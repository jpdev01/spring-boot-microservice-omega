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
    private Integer permission;
    private Active active;


    public User(){}

    public User(String login, String password, Integer permission) {
        this.setLogin(login);
        this.setPassword(password);
        this.setPermission(permission);
    }

    public User(Integer id, String login, String password, Integer permission) {
        this.setId(id);
        this.setLogin(login);
        this.setPassword(password);
        this.setPermission(permission);
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

    public Integer getPermission() {
        // 0 = comum
        // 1 = adm
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }
}
