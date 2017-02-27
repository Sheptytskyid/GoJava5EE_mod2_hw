package jdbchomework.dao.model;


import jdbchomework.entity.Customer;
import jdbchomework.entity.Project;

import java.util.List;

public interface CustomersDao extends Dao<Customer> {

    Customer getByName(String name);

    int deleteByName(String name);

    List<Project> getCustomersProject(Customer customer);

}
