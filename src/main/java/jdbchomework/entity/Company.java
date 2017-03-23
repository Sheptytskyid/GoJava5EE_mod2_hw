package jdbchomework.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company extends AbstractEntity {
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, orphanRemoval = false)
    @JoinColumn(name = "company_id")
    private List<Project> projects;

    public Company() {
    }

    public Company(String name, long id) {
        super(id, name);
    }

    public Company(String name, List<Project> projects) {
        super(name);
        this.projects = projects;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Company{\n");
        sb.append("\tid = ").append(getId()).append(" \n");
        sb.append("\tname = ").append(getName()).append(" \n");
        sb.append("\tprojects = ").append(projects).append(" \n");
        sb.append('}');
        return sb.toString();
    }
}