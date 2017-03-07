package jdbchomework.entity;

import javax.persistence.*;


import java.util.List;

@Entity
@Table(name = "developers")
public class Developer extends AbstractEntity {
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "developers_skills",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<Skill> skills;

    private int salary;

    public Developer() {
    }

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

    @Column(name = "salary")
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Developer developer = (Developer) o;

        if (salary != developer.salary) return false;
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

