package com.soc.jwt.service;

import com.soc.jwt.exception.UserNotFoundException;
import com.soc.jwt.model.User;
import com.soc.jwt.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);

    }

    @Override
    public User getUserByNameAndPassword(String name, String password) throws UserNotFoundException {
        User user = userRepository.findByUserNameAndPassword(name, password);
        if (user == null) {
            throw new UserNotFoundException("invalid id and password");
        }
        return user;
    }
}
