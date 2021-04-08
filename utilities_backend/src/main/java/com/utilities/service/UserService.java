/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.service;

import com.utilities.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService extends GeneralService<User> {

    Page<User> findUsersIds(Pageable pageable);

}
