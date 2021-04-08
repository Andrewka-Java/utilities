/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.rest;

import com.utilities.model.User;
import com.utilities.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.utilities.config.Constant.APP_VERSION_URL;

@RestController
@RequestMapping(value = "/api/" + APP_VERSION_URL + "/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public User findUser(@PathVariable("id") final int id) {
        return userService.findById(id);
    }

    @GetMapping
    public List<User> findUsers() {
        return userService.findAll();
    }

    @PostMapping
    public User addUser(@RequestBody final User user) {
        return userService.add(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody final User user) {
        return userService.update(user);
    }

    @GetMapping("/pages/{page}")
    public Page<User> pageUsers(@PathVariable("page") final int page) {
        return userService.findUsersIds(PageRequest.of(page - 1, 3));
    }


}
