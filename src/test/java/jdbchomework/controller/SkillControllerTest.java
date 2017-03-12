package jdbchomework.controller;

import static jdbchomework.utils.TestUtils.ID;
import static jdbchomework.utils.TestUtils.NAME;
import static jdbchomework.utils.TestUtils.ALL_SKILLS;
import static jdbchomework.utils.TestUtils.SKILL_RESULT;

import jdbchomework.service.SkillService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class SkillControllerTest {

    private SkillController skillController;
    private SkillService skillService = mock(SkillService.class);

    @Before
    public void setUp() {
        skillController = new SkillController(skillService);
    }

    @Test
    public void shouldGetAllSkills() {
        when(skillService.getAllSkills()).thenReturn(ALL_SKILLS);
        assertEquals(ALL_SKILLS, skillController.getAllSkills());
        verify(skillService, times(1)).getAllSkills();
    }

    @Test
    public void shouldAddSkillToDb() {
        skillController.addSkill(NAME);
        verify(skillService, times(1)).addSkill(NAME);
    }

    @Test
    public void shouldGetSkillById() {
        when(skillService.getSkillById(ID)).thenReturn(SKILL_RESULT);
        assertEquals(SKILL_RESULT, skillController.getSkillById(ID));
        verify(skillService, times(1)).getSkillById(ID);
    }

    @Test
    public void shouldDeleteSkillById() {
        when(skillService.deleteSkillById(ID)).thenReturn(true);
        assertTrue(skillController.deleteSkillById(ID));
        verify(skillService, times(1)).deleteSkillById(ID);
    }

    @Test
    public void shouldUpdateSkillById() {
        when(skillService.updateSkillById(ID, NAME)).thenReturn(true);
        assertTrue(skillController.updateSkillById(ID, NAME));
        verify(skillService, times(1)).updateSkillById(ID, NAME);
    }

}