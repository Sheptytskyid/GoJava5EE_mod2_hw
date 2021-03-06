package jdbchomework.console;

import java.util.ArrayList;
import java.util.List;

public class MenuContents {

    public static final String SPLIT_LINE = "**************************************************************";
    public static final String GO_TO_MAIN_MENU = "Go to main menu";
    private List<String> siteHeader = new ArrayList<>();
    private List<String> serviceHeader = new ArrayList<>();
    private List<String> serviceHeaderCompany = new ArrayList<>();
    private List<String> serviceHeaderCustomer = new ArrayList<>();
    private List<String> serviceHeaderDeveloper = new ArrayList<>();
    private List<String> serviceHeaderProject = new ArrayList<>();
    private List<String> serviceHeaderSkill = new ArrayList<>();
    private List<String> serviceMainMenu = new ArrayList<>();
    private List<String> serviceCompaniesMenu = new ArrayList<>();
    private List<String> serviceCustomersMenu = new ArrayList<>();
    private List<String> serviceDevelopersMenu = new ArrayList<>();
    private List<String> serviceProjectsMenu = new ArrayList<>();
    private List<String> serviceSkillsMenu = new ArrayList<>();
    private List<String> selectionHeader = new ArrayList<>();
    private List<String> selectionMenu = new ArrayList<>();

    public void makeMenus() {
        siteHeader.add(SPLIT_LINE);
        siteHeader.add("\t\tWelcome to DB manager");
        siteHeader.add(SPLIT_LINE);
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
        serviceCompaniesMenu.add(GO_TO_MAIN_MENU);
        serviceCustomersMenu.add("Get all customers");
        serviceCustomersMenu.add("Add new customer");
        serviceCustomersMenu.add("Get customer by ID");
        serviceCustomersMenu.add("Update customer by ID");
        serviceCustomersMenu.add("Delete customer by ID");
        serviceCustomersMenu.add(GO_TO_MAIN_MENU);
        serviceDevelopersMenu.add("Get all developers");
        serviceDevelopersMenu.add("Add new developer");
        serviceDevelopersMenu.add("Get developer by ID");
        serviceDevelopersMenu.add("Update developer by ID");
        serviceDevelopersMenu.add("Delete developer by ID");
        serviceDevelopersMenu.add(GO_TO_MAIN_MENU);
        serviceProjectsMenu.add("Get all projects");
        serviceProjectsMenu.add("Add new project");
        serviceProjectsMenu.add("Get project by ID");
        serviceProjectsMenu.add("Update project by ID");
        serviceProjectsMenu.add("Delete project by ID");
        serviceProjectsMenu.add(GO_TO_MAIN_MENU);
        serviceSkillsMenu.add("Get all skills");
        serviceSkillsMenu.add("Add new skill");
        serviceSkillsMenu.add("Get skill by ID");
        serviceSkillsMenu.add("Update skill by ID");
        serviceSkillsMenu.add("Delete skill by ID");
        serviceSkillsMenu.add(GO_TO_MAIN_MENU);
        selectionHeader.add(SPLIT_LINE);
        selectionMenu.add("Yes");
        selectionMenu.add("No");
    }

    public List<String> getSiteHeader() {
        return siteHeader;
    }

    public List<String> getServiceHeader() {
        return serviceHeader;
    }

    public List<String> getServiceMainMenu() {
        return serviceMainMenu;
    }

    public List<String> getServiceCompaniesMenu() {
        return serviceCompaniesMenu;
    }

    public List<String> getServiceCustomersMenu() {
        return serviceCustomersMenu;
    }

    public List<String> getServiceDevelopersMenu() {
        return serviceDevelopersMenu;
    }

    public List<String> getServiceProjectsMenu() {
        return serviceProjectsMenu;
    }

    public List<String> getServiceSkillsMenu() {
        return serviceSkillsMenu;
    }

    public List<String> getSelectionHeader() {
        return selectionHeader;
    }

    public List<String> getSelectionMenu() {
        return selectionMenu;
    }

    public List<String> getServiceHeaderCompany() {
        return serviceHeaderCompany;
    }

    public List<String> getServiceHeaderCustomer() {
        return serviceHeaderCustomer;
    }

    public List<String> getServiceHeaderDeveloper() {
        return serviceHeaderDeveloper;
    }

    public List<String> getServiceHeaderProject() {
        return serviceHeaderProject;
    }

    public List<String> getServiceHeaderSkill() {
        return serviceHeaderSkill;
    }
}