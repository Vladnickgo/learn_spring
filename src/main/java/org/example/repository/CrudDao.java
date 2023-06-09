package org.example.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface CrudDao<T, ID extends Serializable> {
    void save(T entity);

    Optional<T> findById(ID id);

    List<T> findAll();

    void update(ID id, T entity);

    void deleteById(ID id);
}
