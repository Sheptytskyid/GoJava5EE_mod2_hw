package jdbchomework.dao.model;

import java.util.List;

public interface GenericDao<T> {

    void create();

    T deleteById(int id);

    T updateById(int id);

    T read(int id);

    List<T> getAll();
}
