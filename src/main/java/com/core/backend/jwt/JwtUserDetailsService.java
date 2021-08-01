package com.core.backend.jwt;

import java.util.ArrayList;
import java.util.Optional;

import com.core.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        com.core.backend.entity.User user = findByLogin(login);
        if(user == null)
        {
            return null;
        }
        Integer userId = userService.validateLogin(login, user.getPassword());

//        if (user.getEmail().equals(email)) {
//            return new User(email, user.getPassword(),
//                    new ArrayList<>());
//        } else {
//            throw new UsernameNotFoundException("User not found with email: " + email);
//        }
        //com.onroad.backend.entity.User user = userService.findById(userId).get();

        return new User(user.getLogin(), user.getPassword(),
                new ArrayList<>());
    }

    private com.core.backend.entity.User findByLogin(String login)
    {
        return userService.getUserByLogin(login);
    }
}


