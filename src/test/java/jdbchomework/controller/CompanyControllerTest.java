package jdbchomework.controller;

import jdbchomework.service.CompanyService;
import org.junit.Before;
import org.junit.Test;

import static jdbchomework.utils.TestUtils.ALL_COMPANIES;
import static jdbchomework.utils.TestUtils.ID;
import static jdbchomework.utils.TestUtils.NAME;
import static jdbchomework.utils.TestUtils.COMPANY_RESULT;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class CompanyControllerTest {
    private CompanyService companyService = mock(CompanyService.class);
    private  CompanyController companyController;


    @Before
    public void setUp() {
        companyController = new CompanyController(companyService);
    }

    @Test
    public void shouldGetAllCompanies() {
        when(companyService.getAllCompanies()).thenReturn(ALL_COMPANIES);
        assertEquals(ALL_COMPANIES, companyController.getAllCompanies());
        verify(companyService).getAllCompanies();

    }

    @Test
    public void shouldGetAllCompanyDevelopers() {
        companyController.getAllCompanyDevelopers(ID);
        verify(companyService).getCompanyDevelopers(ID);
    }

    @Test
    public void shouldAddCompanyToDb() {
        companyController.addCompany(NAME);
        verify(companyService).addCompany(NAME);
    }

    @Test
    public void shouldGetCompanyById() {
        when(companyService.getCompanyById(ID)).thenReturn(COMPANY_RESULT);
        assertEquals(COMPANY_RESULT, companyController.getCompanyById(ID));

    }

    @Test
    public void shouldDeleteCompanyById() {
        when(companyService.deleteCompanyById(ID)).thenReturn(true);
        assertTrue(companyController.deleteCompanyById(ID));
        verify(companyService).deleteCompanyById(ID);

    }

    @Test
    public void shouldUpdateCompanyById() {
        when(companyService.updateCompanyById(ID, NAME)).thenReturn(true);
        assertTrue(companyController.updateCompanyById(ID, NAME));

    }

}