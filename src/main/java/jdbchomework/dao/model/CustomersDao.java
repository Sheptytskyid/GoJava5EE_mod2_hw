package jdbchomework.dao.model;


import jdbchomework.entity.Customer;
import jdbchomework.entity.Project;

import java.util.List;

public interface CustomersDao extends Dao<Customer> {

    public Customer getByName(String aName);

    public int deleteByName(String aName);

    public List<Project> getCustomersProject(Customer customer);

}
