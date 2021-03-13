/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.service.impl;

import com.utilities.model.User;
import com.utilities.repository.UserRepository;
import com.utilities.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(final Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with id [" + id + "] not found"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User add(final User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(final User user) {
        return userRepository.save(user);
    }

}
