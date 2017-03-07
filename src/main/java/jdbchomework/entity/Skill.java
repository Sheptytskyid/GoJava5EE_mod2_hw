package jdbchomework.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table (name = "skills")
public class Skill extends AbstractEntity {

    private List<Developer> developers;



    public Skill(long id, String name) {
        super(id, name);
    }

    public Skill(String name) {
        super(name);
    }

    public Skill() {
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Skill{");
        sb.append("id = ").append(getId()).append(" ");
        sb.append("name = ").append(getName()).append(" ");
        sb.append('}');
        return sb.toString();
    }
    @ManyToMany(mappedBy = "skills")
    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }
}
