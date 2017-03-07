package jdbchomework.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "skills")
public class Skill extends AbstractEntity {

    @ManyToMany(mappedBy = "skills")
    private List<Developer> developers;

    public Skill() {}

    public Skill(long id, String name) {
        super(id, name);
    }

    public Skill(String name) {
        super(name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Skill{");
        sb.append("id = ").append(getId()).append(" ");
        sb.append("name = ").append(getName()).append(" ");
        sb.append('}');
        return sb.toString();
    }
}
