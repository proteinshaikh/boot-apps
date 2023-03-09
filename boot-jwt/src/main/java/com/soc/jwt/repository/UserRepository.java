package com.soc.jwt.repository;

import com.soc.jwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {


    public User findByUserNameAndPassword(String name, String password);
}
