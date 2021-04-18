package com.onroad.backend.repository;

import com.onroad.backend.entity.Provider;
import com.onroad.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

//    @Query(value = "select id FROM user u " +
//            "WHERE u.login = :paramLogin " +
//            "AND u.password = :paramPassword")
//    Integer validate(@Param("login") String paramLogin, @Param("password") String paramPassword);

    @Query("SELECT u.id FROM User u WHERE u.login = ?1 and u.password = ?2")
    Integer validate(String login, String password);

    User findByLogin(String login);

}
