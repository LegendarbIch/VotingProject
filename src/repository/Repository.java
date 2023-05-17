package repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T, ID> {
    void save(T obj);
    void delete(T obj);

    T findById(ID id);
    Optional<T> find(T obj);
    List<T> list();
}
