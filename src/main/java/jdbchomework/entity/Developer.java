package jdbchomework.entity;

import java.util.List;


public class Developer {

    private int id;
    private String name;
    private List<Skill> skills;
    private int salary;

    public Developer(String name) {
        this.name = name;
    }

    public Developer(String name, int id) {
        this.name = name;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Developer{"
                + "name='" + name + '\''
                + ", skills=" + skills
                + ", salary=" + salary
                + '}';
    }
}

