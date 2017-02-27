package jdbchomework.dao.model;

import java.util.List;

/**
 * Created by GetFire on 25.02.2017.
 */
public interface Dao<T> {
    void add(T toAdd);

    List<T> getAll();

    T getById(int id);

    int deleteById(int id);

    void updateById(int id, T toUpdate);


}

