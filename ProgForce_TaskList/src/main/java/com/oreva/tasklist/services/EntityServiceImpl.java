package com.oreva.tasklist.services;

import com.oreva.tasklist.entities.Entity;

import java.util.List;

public abstract class EntityServiceImpl<E extends Entity> implements EntityService<E> {

    @Override
    public E findById(Long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void create(E entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(E entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(E entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> findAll() {
        throw new UnsupportedOperationException();
    }
}
