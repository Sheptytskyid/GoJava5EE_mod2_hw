package jdbchomework.console;

import java.util.ArrayList;
import java.util.List;

public class ListMenu {

    private static List<String> siteHeader = new ArrayList<>();
    private static List<String> serviceHeader = new ArrayList<>();
    private static List<String> serviceMainMenu = new ArrayList<>();
    private static List<String> serviceCompaniesMenu = new ArrayList<>();
    private static List<String> serviceCustomersMenu = new ArrayList<>();
    private static List<String> serviceDevelopersMenu = new ArrayList<>();
    private static List<String> serviceProjectsMenu = new ArrayList<>();
    private static List<String> serviceSkillsMenu = new ArrayList<>();
    private static List<String> selectionHeader = new ArrayList<>();
    private static List<String> selectionMenu = new ArrayList<>();

    private ListMenu() {
    }

    public static void makeMenus() {
        siteHeader.add("**************************************************************");
        siteHeader.add("\t\tWelcome to DB manager");
        siteHeader.add("**************************************************************");
        siteHeader.add(" ");

        serviceHeader.add("**************************************************************");
        serviceHeader.add("\n\tMain menu");
        serviceMainMenu.add("Go to companies");
        serviceMainMenu.add("Go to customers");
        serviceMainMenu.add("Go to developers");
        serviceMainMenu.add("Go to projects");
        serviceMainMenu.add("Go to skills");
        serviceCompaniesMenu.add("Get all companies");
        serviceCompaniesMenu.add("Add new company");
        serviceCompaniesMenu.add("Update company by ID");
        serviceCompaniesMenu.add("Delete company by ID");
        serviceCustomersMenu.add("Get all customers");
        serviceCustomersMenu.add("Add new customer");
        serviceCustomersMenu.add("Update customer by ID");
        serviceCustomersMenu.add("Delete customer by ID");
        serviceDevelopersMenu.add("Get all developers");
        serviceDevelopersMenu.add("Add new developer");
        serviceDevelopersMenu.add("Update developer by ID");
        serviceDevelopersMenu.add("Delete developer by ID");
        serviceProjectsMenu.add("Get all projects");
        serviceProjectsMenu.add("Add new project");
        serviceProjectsMenu.add("Update project by ID");
        serviceProjectsMenu.add("Delete project by ID");
        serviceSkillsMenu.add("Get all skills");
        serviceSkillsMenu.add("Add new skill");
        serviceSkillsMenu.add("Update skill by ID");
        serviceSkillsMenu.add("Delete skill by ID");
        serviceMainMenu.add("Exit");

        selectionHeader.add("**************************************************************");
        selectionMenu.add("Yes");
        selectionMenu.add("No");
    }

    public static List<String> getSiteHeader() {
        return siteHeader;
    }

    public static List<String> getServiceHeader() {
        return serviceHeader;
    }

    public static List<String> getServiceMainMenu() {
        return serviceMainMenu;
    }

    public static List<String> getServiceCompaniesMenu() {
        return serviceCompaniesMenu;
    }

    public static List<String> getServiceCustomersMenu() {
        return serviceCustomersMenu;
    }

    public static List<String> getServiceDevelopersMenu() {
        return serviceDevelopersMenu;
    }

    public static List<String> getServiceProjectsMenu() {
        return serviceProjectsMenu;
    }

    public static List<String> getServiceSkillsMenu() {
        return serviceSkillsMenu;
    }

    public static List<String> getSelectionHeader() {
        return selectionHeader;
    }

    public static List<String> getSelectionMenu() {
        return selectionMenu;
    }
}