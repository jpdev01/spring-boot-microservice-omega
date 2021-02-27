package com.onroad.backend.repository;

import com.onroad.backend.entity.Provider;
import com.onroad.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value="select id from User where lower(login) = :paramLogin AND lower(password) = :paramPassword")
    public Integer validate(@Param("login") String paramLogin, @Param("password") String paramPassword);

}
