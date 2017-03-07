package jdbchomework.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "developers")
public class Developer extends AbstractEntity {
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "developers_skills")
    private List<Skill> skills;
    @Column(name = "salary")
    private int salary;

    public Developer() {}

    public Developer(long id, String name, int salary) {
        super(id, name);
        this.salary = salary;
    }

    public Developer(String name) {
        super(name);
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Developer{");
        sb.append("id = ").append(getId()).append(" ");
        sb.append("name = ").append(getName()).append(" ");
        sb.append("skills = ").append(skills).append(" ");
        sb.append(", salary = ").append(salary).append(" ");
        sb.append('}');
        return sb.toString();
    }
}

