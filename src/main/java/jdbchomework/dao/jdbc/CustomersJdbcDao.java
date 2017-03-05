package jdbchomework.dao.jdbc;

import jdbchomework.dao.model.CustomersDao;
import jdbchomework.entity.Customer;
import org.hibernate.SessionFactory;

public class CustomersJdbcDao extends AbstractDao<Customer> implements CustomersDao {

    public CustomersJdbcDao(SessionFactory sessionFactory, String entity, Class<Customer> clazz) {
        super(sessionFactory, entity, clazz);
    }
}
