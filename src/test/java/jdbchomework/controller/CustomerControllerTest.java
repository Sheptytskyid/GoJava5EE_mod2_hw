package jdbchomework.controller;


import static jdbchomework.utils.TestUtils.ID;
import static jdbchomework.utils.TestUtils.NAME;
import static jdbchomework.utils.TestUtils.ALL_CUSTOMERS;
import static jdbchomework.utils.TestUtils.CUSTOMER_RESULT;

import jdbchomework.service.CustomerService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class CustomerControllerTest {
    private CustomerController customerController;
    private CustomerService customerService = mock(CustomerService.class);

    @Before
    public void setUp() {
        customerController = new CustomerController(customerService);
    }

    @Test
    public void shouldGetAllCustomers() {
        when(customerService.getAllCustomers()).thenReturn(ALL_CUSTOMERS);
        assertEquals(ALL_CUSTOMERS, customerController.getAllCustomers());
        verify(customerService).getAllCustomers();

    }

    @Test
    public void shouldAddCustomerToDb() {
        customerController.addCustomer(NAME);
        verify(customerService).addCustomer(NAME);
    }

    @Test
    public void shouldGetCustomerById() {
        when(customerService.getCustomerById(ID)).thenReturn(CUSTOMER_RESULT);
        assertEquals(CUSTOMER_RESULT, customerController.getCustomerById(ID));
    }

    @Test
    public void shouldDeleteCustomerById() {
        when(customerController.deleteCustomerById(ID)).thenReturn(true);
        assertTrue(customerController.deleteCustomerById(ID));
        verify(customerService).deleteCustomerById(ID);

    }

    @Test
    public void updateCustomerById() {
        when(customerService.updateCustomerById(ID, NAME)).thenReturn(true);
        assertTrue(customerController.updateCustomerById(ID, NAME));
        verify(customerService).updateCustomerById(ID, NAME);
    }

}