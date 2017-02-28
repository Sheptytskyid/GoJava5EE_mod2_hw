package jdbchomework.service;

import jdbchomework.dao.jdbc.DevelopersJdbcDao;
import jdbchomework.entity.Developer;

import java.util.List;

public class DeveloperService {

    private DevelopersJdbcDao developersJdbcDao;

    public DeveloperService(DevelopersJdbcDao developersJdbcDao) {
        this.developersJdbcDao = developersJdbcDao;
    }

    public List<Developer> getAll() {
        return developersJdbcDao.getAll();
    }
}
