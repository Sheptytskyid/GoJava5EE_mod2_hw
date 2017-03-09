package jdbchomework.console;

import java.util.ArrayList;
import java.util.List;

public class ListMenu {

    private static List<String> siteHeader = new ArrayList<>();
    private static List<String> serviceHeader = new ArrayList<>();
    private static List<String> serviceHeaderCompany = new ArrayList<>();
    private static List<String> serviceHeaderCustomer = new ArrayList<>();
    private static List<String> serviceHeaderDeveloper = new ArrayList<>();
    private static List<String> serviceHeaderProject = new ArrayList<>();
    private static List<String> serviceHeaderSkill = new ArrayList<>();
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
        serviceHeader.add("\n\tMain menu");
        serviceHeaderCompany.add("\n\tCompany menu");
        serviceHeaderCustomer.add("\n\tCustomer menu");
        serviceHeaderDeveloper.add("\n\tDeveloper menu");
        serviceHeaderProject.add("\n\tProject menu");
        serviceHeaderSkill.add("\n\tSkill menu");
        serviceMainMenu.add("Go to companies");
        serviceMainMenu.add("Go to customers");
        serviceMainMenu.add("Go to developers");
        serviceMainMenu.add("Go to projects");
        serviceMainMenu.add("Go to skills");
        serviceMainMenu.add("Exit");
        serviceCompaniesMenu.add("Get all companies");
        serviceCompaniesMenu.add("Add new company");
        serviceCompaniesMenu.add("Get company by ID");
        serviceCompaniesMenu.add("Get company developers by company id*");
        serviceCompaniesMenu.add("Update company by ID");
        serviceCompaniesMenu.add("Delete company by ID");
        serviceCompaniesMenu.add("Go to main menu \n __________________________ \n *work only via hibernate");
        serviceCustomersMenu.add("Get all customers");
        serviceCustomersMenu.add("Add new customer");
        serviceCustomersMenu.add("Get customer by ID");
        serviceCustomersMenu.add("Update customer by ID");
        serviceCustomersMenu.add("Delete customer by ID");
        serviceCustomersMenu.add("Go to main menu");
        serviceDevelopersMenu.add("Get all developers");
        serviceDevelopersMenu.add("Add new developer");
        serviceDevelopersMenu.add("Get developer by ID");
        serviceDevelopersMenu.add("Update developer by ID");
        serviceDevelopersMenu.add("Delete developer by ID");
        serviceDevelopersMenu.add("Go to main menu");
        serviceProjectsMenu.add("Get all projects");
        serviceProjectsMenu.add("Add new project");
        serviceProjectsMenu.add("Get project by ID");
        serviceProjectsMenu.add("Update project by ID");
        serviceProjectsMenu.add("Delete project by ID");
        serviceProjectsMenu.add("Go to main menu");
        serviceSkillsMenu.add("Get all skills");
        serviceSkillsMenu.add("Add new skill");
        serviceSkillsMenu.add("Get skill by ID");
        serviceSkillsMenu.add("Update skill by ID");
        serviceSkillsMenu.add("Delete skill by ID");
        serviceSkillsMenu.add("Go to main menu");
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

    public static List<String> getServiceHeaderCompany() {
        return serviceHeaderCompany;
    }

    public static List<String> getServiceHeaderCustomer() {
        return serviceHeaderCustomer;
    }

    public static List<String> getServiceHeaderDeveloper() {
        return serviceHeaderDeveloper;
    }

    public static List<String> getServiceHeaderProject() {
        return serviceHeaderProject;
    }

    public static List<String> getServiceHeaderSkill() {
        return serviceHeaderSkill;
    }
}