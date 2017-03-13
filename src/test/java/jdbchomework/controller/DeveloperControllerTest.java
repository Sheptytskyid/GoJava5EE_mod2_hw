package jdbchomework.controller;

import jdbchomework.service.DeveloperService;
import org.junit.Before;
import org.junit.Test;

import static jdbchomework.utils.TestUtils.ALL_DEVELOPERS;
import static jdbchomework.utils.TestUtils.ID;
import static jdbchomework.utils.TestUtils.NAME;
import static jdbchomework.utils.TestUtils.DEVELOPER_RESULT;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DeveloperControllerTest {

    private DeveloperController developerController;
    private DeveloperService developerService = mock(DeveloperService.class);

    @Before
    public void setUp() {
        developerController = new DeveloperController(developerService);
    }

    @Test
    public void shouldGetAllDevelopers() {
        when(developerService.getAllDevelopers()).thenReturn(ALL_DEVELOPERS);
        assertEquals(ALL_DEVELOPERS, developerController.getAllDevelopers());
    }

    @Test
    public void shouldAddDeveloperToDB() {
        developerController.addDeveloper(NAME);
        verify(developerService, times(1)).addDeveloper(NAME);
    }

    @Test
    public void shouldGetDeveloperById() {
        when(developerService.getDeveloperById(ID)).thenReturn(DEVELOPER_RESULT);
        assertEquals(DEVELOPER_RESULT, developerController.getDeveloperById(ID));
    }

    @Test
    public void shouldDeleteDeveloperById() {
        when(developerService.deleteDeveloperById(ID)).thenReturn(true);
        assertTrue(developerController.deleteDeveloperById(ID));
    }

    @Test
    public void shouldUpdateDeveloperById() {
        when(developerService.updateDeveloperById(ID, NAME)).thenReturn(true);
        assertTrue(developerController.updateDeveloperById(ID, NAME));
    }

}