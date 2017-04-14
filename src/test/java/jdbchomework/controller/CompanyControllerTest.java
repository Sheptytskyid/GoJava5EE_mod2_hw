package jdbchomework.controller;

import jdbchomework.service.CompanyService;
import org.junit.Before;
import org.junit.Test;

import static jdbchomework.utils.TestUtils.ALL_COMPANIES;
import static jdbchomework.utils.TestUtils.ID;
import static jdbchomework.utils.TestUtils.COMPANY_NAME;
import static jdbchomework.utils.TestUtils.COMPANY_RESULT;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CompanyControllerTest {
    private CompanyService companyService = mock(CompanyService.class);
    private CompanyController companyController;


    @Before
    public void setUp() {
        companyController = new CompanyController(companyService);
    }

    @Test
    public void shouldGetAllCompanies() {
        when(companyService.getAllCompanies()).thenReturn(ALL_COMPANIES);
        assertEquals(ALL_COMPANIES, companyController.getAllCompanies());
    }

    @Test
    public void shouldGetAllCompanyDevelopers() {
        companyController.getAllCompanyDevelopers(anyInt());
        verify(companyService, times(1)).getCompanyDevelopers(anyInt());
    }

    @Test
    public void shouldAddCompanyToDb() {
        companyController.addCompany(anyString());
        verify(companyService, times(1)).addCompany(anyString());
    }

    @Test
    public void shouldGetCompanyById() {
        when(companyService.getCompanyById(anyInt())).thenReturn(COMPANY_RESULT);
        assertEquals(COMPANY_RESULT, companyController.getCompanyById(ID));
        assertEquals(COMPANY_RESULT, companyController.getCompanyById(12));
        assertEquals(COMPANY_RESULT, companyController.getCompanyById(153));
        verify(companyService, times(3)).getCompanyById(anyInt());
    }

    @Test
    public void shouldDeleteCompanyById() {
        when(companyService.deleteCompanyById(anyInt())).thenReturn(true);
        assertTrue(companyController.deleteCompanyById(anyInt()));
        assertTrue(companyController.deleteCompanyById(ID));
        assertTrue(companyController.deleteCompanyById(3354));
        verify(companyService, times(3)).deleteCompanyById(anyInt());
    }

    @Test
    public void shouldUpdateCompanyById() {
        when(companyService.updateCompanyById(anyInt(), anyString())).thenReturn(true);
        assertTrue(companyController.updateCompanyById(ID, COMPANY_NAME));
        assertTrue(companyController.updateCompanyById(anyInt(), anyString()));
        verify(companyService, times(2)).updateCompanyById(anyInt(), anyString());
    }

}