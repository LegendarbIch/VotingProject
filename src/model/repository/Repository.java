package model.repository;

import model.User;

import java.util.List;
import java.util.Set;

public interface Repository<T, ID> {
    void save(T obj);
    void delete(T obj);

    T findById(ID id);
    List<T> list();
}
