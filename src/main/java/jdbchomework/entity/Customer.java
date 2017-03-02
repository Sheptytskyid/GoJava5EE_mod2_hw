package jdbchomework.entity;

import java.util.List;

public class Customer extends AbstractEntity {

    private List<Project> projects;

    public Customer(long id, String name) {
        super(id, name);
    }

    public Customer(String name) {
        super(name);
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("id = ").append(getId()).append(" ");
        sb.append("name = ").append(getName()).append(" ");
        sb.append("projects = ").append(projects).append(" ");
        sb.append('}');
        return sb.toString();
    }
}
