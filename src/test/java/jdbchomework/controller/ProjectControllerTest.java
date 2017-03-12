package jdbchomework.controller;

import jdbchomework.service.ProjectService;
import org.junit.Before;
import org.junit.Test;

import static jdbchomework.utils.TestUtils.ALL_PROJECTS;
import static jdbchomework.utils.TestUtils.ID;
import static jdbchomework.utils.TestUtils.NAME;
import static jdbchomework.utils.TestUtils.COST;
import static jdbchomework.utils.TestUtils.PROJECT_RESULT;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class ProjectControllerTest {
    private ProjectController projectController;
    private ProjectService projectService = mock(ProjectService.class);

    @Before
    public void setUp() {
        projectController = new ProjectController(projectService);
    }

    @Test
    public void shouldGetAllProjects() {
        when(projectService.getAllProjects()).thenReturn(ALL_PROJECTS);
        assertEquals(ALL_PROJECTS, projectController.getAllProjects());
        verify(projectService).getAllProjects();
    }

    @Test
    public void shouldAddProjectToDb() {
        projectController.addProject(NAME, COST);
        verify(projectService).addProject(NAME, COST);
    }

    @Test
    public void shouldGetProjectById() {
        when(projectService.getProjectById(ID)).thenReturn(PROJECT_RESULT);
        assertEquals(PROJECT_RESULT, projectController.getProjectById(ID));
        verify(projectService).getProjectById(ID);
    }

    @Test
    public void shouldDeleteProjectById() {
        when(projectService.deleteProjectById(ID)).thenReturn(true);
        assertTrue(projectController.deleteProjectById(ID));
        verify(projectService).deleteProjectById(ID);

    }

    @Test
    public void shouldUpdateProjectById() {
        when(projectService.updateProjectById(ID, NAME, COST)).thenReturn(true);
        assertTrue(projectController.updateProjectById(ID, NAME, COST));
        verify(projectService).updateProjectById(ID, NAME, COST);

    }

}