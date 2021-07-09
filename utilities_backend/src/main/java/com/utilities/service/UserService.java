/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.service;

import com.utilities.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends GeneralService<User>, UserDetailsService {

    Page<User> findUsersIds(Pageable pageable);

    User setAuthForUser(String username, String accessToken, String refreshToken);

}
