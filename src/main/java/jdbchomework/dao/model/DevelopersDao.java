package jdbchomework.dao.model;


import jdbchomework.entity.Developer;
import jdbchomework.entity.Project;
import jdbchomework.entity.Skill;

import java.util.List;

public interface DevelopersDao extends Dao<Developer> {

    Developer getByName(String name);

    List<Developer> getBySalary(int salary);

    List<Project> getDeveloperProject(Developer developer);

    int deleteByName(String name);

    List<Skill> getDeveloperSkills(Developer developer);
}
