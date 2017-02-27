package jdbchomework.dao.model;

import jdbchomework.entity.Developer;
import jdbchomework.entity.Project;

import java.util.List;

public interface ProjectsDao extends Dao<Project> {

    Project getByName(String projectName);

    int deleteByName(String projectName);

    List<Project> getAllProjects(String companyName);

    List<Developer> getDevelopers(String projectName);


}
