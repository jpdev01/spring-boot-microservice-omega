package com.core.backend.entity;

import com.core.custom.Active;
import com.core.custom.Permission;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private String password;

    @Enumerated(EnumType.ORDINAL)
    private Permission permission = Permission.LESS;

    @Enumerated(EnumType.ORDINAL)
    private Active active = Active.ACTIVE;

    @OneToOne
    private Customer customer;


    public User(){}

    public User(String login, String password, Permission permission) {
        this.setLogin(login);
        this.setPassword(password);
        this.setPermission(permission);
    }

    public User(Integer id, String login, String password, Permission permission) {
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

    public Permission getPermission() {
        // 0 = comum
        // 1 = adm
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
