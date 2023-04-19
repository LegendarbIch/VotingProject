package model.repository;

import model.User;

import java.util.List;

public interface Repository<T, ID> {
    void save(T obj);
    void delete(T obj);

    T findById(ID id);
    List<T> list();
}
