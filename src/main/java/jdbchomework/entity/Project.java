package jdbchomework.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project extends AbstractEntity {

    @Column(name = "cost")
    private int cost;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
    List<Developer> developers;

    public Project() {
    }

    public Project(long id, String name, int cost) {
        super(id, name);
        this.cost = cost;
    }

    public Project(String name, int cost) {
        super(name);
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Project{");
        sb.append("id = ").append(getId()).append(" ");
        sb.append("name = ").append(getName()).append(" ");
        sb.append("cost = ").append(cost).append(" ");
        sb.append("developers = ").append(developers).append(" ");
        sb.append('}');
        return sb.toString();
    }
}