package jdbchomework.entity;

import java.util.List;


public class Developer {

    private String name;
    private List<String> skills;
    private int salary;

    public Developer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
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
        return "Developer{"
            + "name='" + name + '\''
            + ", skills=" + skills
            + ", salary=" + salary
            + '}';
    }
}
