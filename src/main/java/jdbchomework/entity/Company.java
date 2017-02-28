package jdbchomework.entity;

import java.util.List;

public class Company extends AbstractEntity {

    private List<Project> projects;
    private List<Developer> developers;

    public Company(String name, long id) {
        super(id, name);
    }

    public Company(String name) {
        super(name);
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
        final StringBuilder sb = new StringBuilder("Company{");
        sb.append("id = ").append(getId()).append(" ");
        sb.append("name = ").append(getName()).append(" ");
        sb.append("projects = ").append(projects).append(" ");
        sb.append("developers = ").append(developers).append(" ");
        sb.append('}');
        return sb.toString();
    }
}
