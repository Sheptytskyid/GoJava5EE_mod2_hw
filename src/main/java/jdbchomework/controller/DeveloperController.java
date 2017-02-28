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
            String ID = Main.getReader().readLine();
            int id = Integer.valueOf(ID);
            developer = developerService.getById(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return developer;
    }

    public void deleteById() {
        System.out.println("Please enter company ID: ");
        try {
            String ID = Main.getReader().readLine();
            int id = Integer.valueOf(ID);
            developerService.deleteById(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateById() {
        try {
            System.out.println("Please enter company ID: ");
            String name = Main.getReader().readLine();
            int id = Integer.valueOf(name);
            System.out.println("Please enter company name: ");
            name = Main.getReader().readLine();
            developerService.updateById(id, name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
