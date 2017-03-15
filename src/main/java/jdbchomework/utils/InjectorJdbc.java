package jdbchomework.utils;

import jdbchomework.console.ConsoleMain;
import jdbchomework.console.ContentsUserMenu;
import jdbchomework.console.VisualUserMenu;
import jdbchomework.controller.CompanyController;
import jdbchomework.controller.CustomerController;
import jdbchomework.controller.DeveloperController;
import jdbchomework.controller.ProjectController;
import jdbchomework.controller.SkillController;
import jdbchomework.dao.hibernate.CompaniesHibDao;
import jdbchomework.dao.jdbc.CompaniesJdbcDao;
import jdbchomework.dao.jdbc.CustomersJdbcDao;
import jdbchomework.dao.jdbc.DevelopersJdbcDao;
import jdbchomework.dao.jdbc.ProjectsJdbcDao;
import jdbchomework.dao.jdbc.SkillsJdbcDao;
import jdbchomework.entity.Company;
import jdbchomework.service.CompanyService;
import jdbchomework.service.CustomerService;
import jdbchomework.service.DeveloperService;
import jdbchomework.service.ProjectService;
import jdbchomework.service.SkillService;

import java.sql.Connection;

public class InjectorJdbc {

    private static Connection connection = ConnectionUtil.getConnection();
    private static CompaniesHibDao companiesJdbcDao =
            new CompaniesHibDao("Company", HibernateUtil.getSessionFactory(), Company.class);
    private static CustomersJdbcDao customersJdbcDao = new CustomersJdbcDao(connection, "customers");
    private static DevelopersJdbcDao developersJdbcDao = new DevelopersJdbcDao(connection, "developers");
    private static ProjectsJdbcDao projectsJdbcDao = new ProjectsJdbcDao(connection, "projects");
    private static SkillsJdbcDao skillsJdbcDao = new SkillsJdbcDao(connection, "skills");
    //work via CompanyHibDao
    private static CompanyService companyService = new CompanyService(companiesJdbcDao);
    private static CustomerService customerService = new CustomerService(customersJdbcDao);
    private static DeveloperService developerService = new DeveloperService(developersJdbcDao);
    private static ProjectService projectService = new ProjectService(projectsJdbcDao);
    private static SkillService skillService = new SkillService(skillsJdbcDao);
    private static CompanyController companyController = new CompanyController(companyService);
    private static CustomerController customerController = new CustomerController(customerService);
    private static DeveloperController developerController = new DeveloperController(developerService);
    private static ProjectController projectController = new ProjectController(projectService);
    private static SkillController skillController = new SkillController(skillService);
    private static VisualUserMenu visualUserMenu = new VisualUserMenu();
    private static ContentsUserMenu contentsUserMenu = new ContentsUserMenu(companyController, customerController,
            developerController, projectController, skillController, visualUserMenu);
    private static ConsoleMain consoleMain = new ConsoleMain(contentsUserMenu);

    private InjectorJdbc() {
        throw new IllegalAccessError("Utility class");
    }

    public static ConsoleMain getConsoleMain() {
        return consoleMain;
    }
}