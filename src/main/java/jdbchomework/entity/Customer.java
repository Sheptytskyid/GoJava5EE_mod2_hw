package jdbchomework.entity;

import java.util.List;

public class Customer extends AbstractEntity {

    private List<Project> customersProject;

    public Customer(long id, String name) {
        super(id, name);
    }

    public List<Project> getCustomersProject() {
        return customersProject;
    }

    public void setCustomersProject(List<Project> customersProject) {
        this.customersProject = customersProject;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("id = ").append(getId()).append(" ");
        sb.append("name = ").append(getName()).append(" ");
        sb.append("customersProject = ").append(customersProject).append(" ");
        sb.append('}');
        return sb.toString();
    }
}
