package jdbchomework.dao.model;

import java.util.List;

public interface Dao<T> {

    void add(T toAdd);

    List<T> getAll();

    T getById(int id);

    int deleteById(int id, String table, String column);

    void updateById(int id, T toUpdate);
}
