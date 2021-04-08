/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.service.impl;

import com.utilities.model.User;
import com.utilities.repository.UserRepository;
import com.utilities.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findById(final int id) {
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

    @Override
    public void delete(final int id) {
        userRepository.deleteById(id);
    }


    @Override
    public Page<User> findUsersIds(final Pageable page) {
        return userRepository.findUsersIds(page);
    }
}
