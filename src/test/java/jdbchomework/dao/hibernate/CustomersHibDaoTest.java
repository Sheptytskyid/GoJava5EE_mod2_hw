package jdbchomework.dao.hibernate;

import jdbchomework.entity.Customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;


import static jdbchomework.utils.TestUtils.ALL_CUSTOMERS;
import static jdbchomework.utils.TestUtils.CUSTOMER_RESULT;
import static jdbchomework.utils.TestUtils.ENTITY_NAME;
import static org.junit.Assert.*;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomersHibDaoTest {
    private CustomersHibDao customersHibDao;
    private Class clazz;
    private AbstractHibDao abstractHibDao;
    private SessionFactory sessionFactory;
    private Session session;

    @Before
    public void setUp() {
        sessionFactory = mock(SessionFactory.class);
        session = mock(Session.class);
        abstractHibDao = mock(AbstractHibDao.class);
        clazz = Customer.class;
        customersHibDao = new CustomersHibDao("Customer", sessionFactory, clazz);
        when(sessionFactory.openSession()).thenReturn(session);

    }

    @Test
    public void shouldGetAllCustomers() {
//        when(abstractHibDao.getAll()).thenReturn(ALL_CUSTOMERS);
//        when(session.createQuery(anyString()).list()).thenReturn(ALL_CUSTOMERS);
//        assertThat(customersHibDao.getAll()).isNotEmpty().hasSize(3).contains(CUSTOMER_RESULT);
    }

    @Test
    public void shouldGetCustomerById() {
        when(session.get(eq(clazz), anyInt())).thenReturn(CUSTOMER_RESULT);
        when(abstractHibDao.getById(anyInt())).thenReturn(CUSTOMER_RESULT);
        assertEquals(CUSTOMER_RESULT,customersHibDao.getById(anyInt()));

    }
}