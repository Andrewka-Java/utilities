/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.repository;

import com.utilities.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT u FROM User u")
    Page<User> findUsersIds(Pageable pageable);

}
