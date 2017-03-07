package jdbchomework.dao.hibernate;

import jdbchomework.dao.model.CustomersDao;
import jdbchomework.entity.Customer;
import org.hibernate.SessionFactory;

public class CustomersHibDao extends AbstractHibDao<Customer> implements CustomersDao {
    public CustomersHibDao(String entityName, SessionFactory sessionFactory, Class<Customer> aClass) {
        super(entityName, sessionFactory, aClass);
    }
}
