package jdbchomework.controller;

import jdbchomework.Main;
import jdbchomework.entity.Skill;
import jdbchomework.service.SkillService;

import java.io.IOException;
import java.util.List;

public class SkillController {

    private SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    public List<Skill> getAll() {
        return skillService.getAll();
    }

    public void add() {
        System.out.println("Please enter skill name: ");
        try {
            String name = Main.getReader().readLine();
            skillService.add(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Skill getById() {
        Skill skill = null;
        System.out.println("Please enter skill ID: ");
        try {
            int id = Integer.valueOf(Main.getReader().readLine());
            skill = skillService.getById(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return skill;
    }

    public void deleteById() {
        System.out.println("Please enter company ID: ");
        try {
            int id = Integer.valueOf(Main.getReader().readLine());
            skillService.deleteById(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateById() {
        try {
            System.out.println("Please enter company ID: ");
            int id = Integer.valueOf(Main.getReader().readLine());
            System.out.println("Please enter company name: ");
            String name = Main.getReader().readLine();
            skillService.updateById(id, name);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
