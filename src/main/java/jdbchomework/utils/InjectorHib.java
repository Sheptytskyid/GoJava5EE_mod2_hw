package jdbchomework.utils;

import jdbchomework.console.CompaniesMenu;
import jdbchomework.console.CustomersMenu;
import jdbchomework.console.DevelopersMenu;
import jdbchomework.console.MainMenu;
import jdbchomework.console.MenuContents;
import jdbchomework.console.MenuLauncher;
import jdbchomework.console.ProjectsMenu;
import jdbchomework.console.SkillsMenu;
import jdbchomework.controller.CompanyController;
import jdbchomework.controller.CustomerController;
import jdbchomework.controller.DeveloperController;
import jdbchomework.controller.ProjectController;
import jdbchomework.controller.SkillController;
import jdbchomework.dao.hibernate.CompaniesHibDao;
import jdbchomework.dao.hibernate.CustomersHibDao;
import jdbchomework.dao.hibernate.DevelopersHibDao;
import jdbchomework.dao.hibernate.ProjectsHibDao;
import jdbchomework.dao.hibernate.SkillsHibDao;
import jdbchomework.entity.Company;
import jdbchomework.entity.Customer;
import jdbchomework.entity.Developer;
import jdbchomework.entity.Project;
import jdbchomework.entity.Skill;
import jdbchomework.service.CompanyService;
import jdbchomework.service.CustomerService;
import jdbchomework.service.DeveloperService;
import jdbchomework.service.ProjectService;
import jdbchomework.service.SkillService;
import org.hibernate.SessionFactory;

public class InjectorHib {

    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static CompaniesHibDao companiesHibDao = new CompaniesHibDao("Company", sessionFactory, Company.class);
    private static CustomersHibDao customersHibDao = new CustomersHibDao("Customer", sessionFactory, Customer.class);
    private static DevelopersHibDao developersHibDao = new DevelopersHibDao("Developer", sessionFactory, Developer.class);
    private static ProjectsHibDao projectsHibDao = new ProjectsHibDao("Project", sessionFactory, Project.class);
    private static SkillsHibDao skillsHibDao = new SkillsHibDao("Skill", sessionFactory, Skill.class);
    private static CompanyService companyService = new CompanyService(companiesHibDao);
    private static CustomerService customerService = new CustomerService(customersHibDao);
    private static DeveloperService developerService = new DeveloperService(developersHibDao);
    private static ProjectService projectService = new ProjectService(projectsHibDao);
    private static SkillService skillService = new SkillService(skillsHibDao);
    private static CompanyController companyController = new CompanyController(companyService);
    private static CustomerController customerController = new CustomerController(customerService);
    private static DeveloperController developerController = new DeveloperController(developerService);
    private static ProjectController projectController = new ProjectController(projectService);
    private static SkillController skillController = new SkillController(skillService);

    private static MenuContents menuContents = new MenuContents();
    private static DevelopersMenu developersMenu = new DevelopersMenu(menuContents, developerController,
        skillController);
    private static SkillsMenu skillsMenu = new SkillsMenu(menuContents, skillController);
    private static CompaniesMenu companiesMenu = new CompaniesMenu(menuContents, companyController,
        projectController);
    private static ProjectsMenu projectsMenu = new ProjectsMenu(menuContents, projectController);
    private static CustomersMenu customersMenu = new CustomersMenu(menuContents, customerController);
    private static MainMenu mainMenu = new MainMenu(menuContents, companiesMenu, customersMenu, developersMenu,
        projectsMenu, skillsMenu);
    private static MenuLauncher menuLauncher = new MenuLauncher(mainMenu, menuContents);

    private InjectorHib() {
        throw new IllegalAccessError("Utility class");
    }

    public static MenuLauncher getMenuLauncher() {
        return menuLauncher;
    }
}
