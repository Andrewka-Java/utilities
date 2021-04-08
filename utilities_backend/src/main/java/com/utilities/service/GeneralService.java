/*
 *   Developed by Andrei Muryn© 2021
 */

package com.utilities.service;

import java.util.List;

public interface GeneralService<T> {

    T findById(int id);

    List<T> findAll();

    T add(T t);

    T update(T t);

    void delete(int id);

}
