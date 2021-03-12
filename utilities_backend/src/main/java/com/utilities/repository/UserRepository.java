/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.repository;

import com.utilities.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
