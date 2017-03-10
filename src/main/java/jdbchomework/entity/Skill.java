package jdbchomework.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "skills")
public class Skill extends AbstractEntity {

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
}