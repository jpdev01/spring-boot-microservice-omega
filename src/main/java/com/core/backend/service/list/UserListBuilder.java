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

        EntityListContent listContent = list.getContent();
        if (listContent == null)
        {
            listContent = new EntityListContent();
        }
        List<String> cols = new ArrayList<>();
        List<List<Object>> rows = new ArrayList<>();
        cols.add("Login");
        cols.add("Permissão");
        listContent.setCols(cols);
            List<User> users = userService.getAll();
        for(User user: users)
        {
            List<Object> row = new ArrayList<>();
            row.add(user.getLogin());
            row.add(user.getPermission().name());
            rows.add(row);
        }
        listContent.setRows(rows);
        list.setContent(listContent);
        list.setView(View.FULL);
        return list;
    }
}
