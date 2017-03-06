package jdbchomework.dao.model;

import java.util.List;

public interface GenericDao<T> {

    void add(T toAdd);

    List<T> getAll();

    T getById(long id);

    boolean deleteById(long id);

    boolean updateById(long id, T toUpdate);
}