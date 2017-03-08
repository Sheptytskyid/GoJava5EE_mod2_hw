package jdbchomework.service;

import jdbchomework.dao.model.DevelopersDao;
import jdbchomework.entity.Developer;

import java.util.List;

public class DeveloperService {

    private DevelopersDao developersDao;

    public DeveloperService(DevelopersDao developersJdbcDao) {
        this.developersDao = developersJdbcDao;
    }

    public List<Developer> getAllDevelopers() {
        return developersDao.getAll();
    }

    public void addDeveloper(String name) {
        Developer developer = new Developer(name);
        developersDao.add(developer);
    }

    public Developer getDeveloperById(int id) {
        return developersDao.getById(id);
    }

    public boolean deleteDeveloperById(int id) {
        return developersDao.deleteById(id);
    }

    public boolean updateDeveloperById(int id, String name) {
        Developer developer = new Developer(name);
        return developersDao.updateById(id, developer);
    }
}
