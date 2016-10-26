package com.oreva.tasklist.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Olga on 10/26/2016.
 */
public interface EntityDAO<E> {
    default E findById(Long id) throws SQLException {
        throw new UnsupportedOperationException();
    }

    default void create(E entity) throws SQLException {
        throw new UnsupportedOperationException();
    }

    default void update(E entity) throws SQLException {
        throw new UnsupportedOperationException();
    }

    default void delete(E entity) throws SQLException {
        throw new UnsupportedOperationException();
    }

    default List<E> findAll() throws SQLException {
        throw new UnsupportedOperationException();
    }
}
