package jdbchomework.entity;

import java.util.List;


public class Developer extends AbstractEntity {

    private List<Skill> skills;
    private int salary;

    public Developer(long id, String name, int salary) {
        super(id, name);
        this.salary = salary;
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

