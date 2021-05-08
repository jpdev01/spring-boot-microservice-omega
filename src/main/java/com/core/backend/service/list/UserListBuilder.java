package com.core.backend.service.list;

import com.core.backend.entity.User;
import com.core.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserListBuilder implements EntityListBuilder {

    @Autowired
    private UserService userService;

    public EntityList build()
    {
        EntityList list = new EntityList();
        List<String> cols = new ArrayList<>();
        cols.add("Login");
        cols.add("Permissão");
        list.setCols(cols);
        List<List<String>> rows = new ArrayList<>();
            List<User> users = userService.getAll();
        for(User user: users)
        {
            List<String> row = new ArrayList<>();
            row.add(user.getLogin());
            row.add(user.getPermission().name());
            rows.add(row);
        }
        list.setRows(rows);
        return list;
    }
}
