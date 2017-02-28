package jdbchomework.controller;

import jdbchomework.Main;
import jdbchomework.entity.Developer;
import jdbchomework.service.DeveloperService;

import java.io.IOException;
import java.util.List;

public class DeveloperController {

    private DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    public List<Developer> getAll() {
        return developerService.getAll();
    }

    public void add() {
        System.out.println("Please enter company name: ");
        try {
            String name = Main.getReader().readLine();
            developerService.add(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Developer getById() {
        Developer developer = null;
        System.out.println("Please enter company ID: ");
        try {
            int id = Integer.valueOf(Main.getReader().readLine());
            developer = developerService.getById(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return developer;
    }

    public void deleteById() {
        System.out.println("Please enter company ID: ");
        try {
            int id = Integer.valueOf(Main.getReader().readLine());
            developerService.deleteById(id);
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
            developerService.updateById(id, name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
