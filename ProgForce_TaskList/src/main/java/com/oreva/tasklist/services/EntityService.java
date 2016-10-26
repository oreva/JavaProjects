package com.oreva.tasklist.services;

import java.util.List;

public interface EntityService<E> {

    E findById(Long id);
    void create(E entity);
    void update(E entity);
    void delete(E entity);

    List<E> findAll();
}
