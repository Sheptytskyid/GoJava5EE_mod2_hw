package jdbchomework.entity;

import java.util.List;

public class Company {

    private int id;
    private String name;
    private List<Project> projects;
    private List<Developer> developers;

    public Company(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    @Override
    public String toString() {
        return "Company{"
            + "name='" + name + '\''
            + '}';
    }
}
