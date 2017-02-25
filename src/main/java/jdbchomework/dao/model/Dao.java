package jdbchomework.dao.model;

import java.util.List;

/**
 * Created by GetFire on 25.02.2017.
 */
public interface Dao<T>{
    public void add(T toAdd);
    public List<T> getAll();
    public T getByID(int id);
    public int deleteByID(int id);
    public void updateByID(int id, T toUpdate);


}
