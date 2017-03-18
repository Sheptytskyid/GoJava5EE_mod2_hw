package jdbchomework.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company extends AbstractEntity {
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, orphanRemoval = false)
    @JoinColumn(name = "company_id")
    private List<Project> projects;

    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinTable(name = "projects",
            joinColumns = {@JoinColumn(name = "company_id")},
            inverseJoinColumns = {@JoinColumn(name = "id")})
    private List<Developer> developers;

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