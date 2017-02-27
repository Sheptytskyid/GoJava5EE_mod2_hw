package jdbchomework.entity;

import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<Project> customersProject;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Customer(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getCustomersProject() {
        return customersProject;
    }

    public void setCustomersProject(List<Project> customersProject) {
        this.customersProject = customersProject;
    }

    @Override
    public String toString() {
        return "Customer{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", customersProject=" + customersProject
                + '}';
    }
}
