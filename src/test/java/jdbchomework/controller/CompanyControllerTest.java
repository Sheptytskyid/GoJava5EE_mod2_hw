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
    private static CompanyController companyController;


    @Before
    public void setUp() {
        companyController = new CompanyController(companyService);
    }

    @Test
    public void shouldGetAllCompanies() {
        when(companyService.getAllCompanies()).thenReturn(ALL_COMPANIES);
        companyController.getAllCompanies();
        verify(companyService).getAllCompanies();
        assertEquals(ALL_COMPANIES, companyController.getAllCompanies());
    }

    @Test
    public void shouldGetAllCompanyDevelopers() {
        companyController.getAllCompanyDevelopers(ID);
        verify(companyService).getCompanyDevelopers(ID);
    }

    @Test
    public void shouldAddCompanyToDb() {
        companyController.addCompany(COMPANY_NAME);
        verify(companyService).addCompany(COMPANY_NAME);
    }

    @Test
    public void shouldGetCompanyById() {
        when(companyService.getCompanyById(ID)).thenReturn(COMPANY_RESULT);
        assertEquals(COMPANY_RESULT, companyController.getCompanyById(ID));

    }

    @Test
    public void shouldDeleteCompanyById() {
        companyController.deleteCompanyById(ID);
        verify(companyService).deleteCompanyById(ID);
    }

    @Test
    public void shouldUpdateCompanyById() {
        when(companyService.updateCompanyById(ID, COMPANY_NAME)).thenReturn(true);
        assertTrue(companyController.updateCompanyById(ID, COMPANY_NAME));

    }

}