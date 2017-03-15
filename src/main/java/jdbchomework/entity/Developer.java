package jdbchomework.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "developers")
public class Developer extends AbstractEntity {
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "developers_skills",
            joinColumns = @JoinColumn(name = "developer_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<Skill> skills;

    private int salary;

    public Developer() {
    }

    public Developer(long id, String name, int salary) {
        super(id, name);
        this.salary = salary;
    }


    public Developer(String name, List<Skill> skills) {
        super(name);
        this.skills = skills;
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Developer developer = (Developer) obj;

        if (salary != developer.salary) {
            return false;
        }
        return skills != null ? skills.equals(developer.skills) : developer.skills == null;
    }

    @Override
    public int hashCode() {
        int result = skills != null ? skills.hashCode() : 0;
        result = 31 * result + salary;
        return result;
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