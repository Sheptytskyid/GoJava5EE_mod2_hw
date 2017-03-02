package jdbchomework.service;

import jdbchomework.dao.model.DevelopersDao;
import jdbchomework.entity.Developer;

import java.util.List;

public class DeveloperService {

    private DevelopersDao developersJdbcDao;

    public DeveloperService(DevelopersDao developersJdbcDao) {
        this.developersJdbcDao = developersJdbcDao;
    }

    public List<Developer> getAll() {
        return developersJdbcDao.getAll();
    }

    public void add(String name) {
        Developer developer = new Developer(name);
        developersJdbcDao.add(developer);
    }

    public Developer getById(int id) {
        return developersJdbcDao.getById(id);
    }

    public boolean deleteById(int id) {
        return developersJdbcDao.deleteById(id);
    }

    public boolean updateById(int id, String name) {
        Developer developer = new Developer(name);
        return developersJdbcDao.updateById(id, developer);
    }
}
