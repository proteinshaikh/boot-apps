package com.soc.jwt.service;

import com.soc.jwt.exception.UserNotFoundException;
import com.soc.jwt.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public void saveUser(User user);
    public User getUserByNameAndPassword(String name, String password) throws UserNotFoundException;
}
