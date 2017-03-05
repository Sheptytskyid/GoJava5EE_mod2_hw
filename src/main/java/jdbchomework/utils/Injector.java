package jdbchomework.utils;

import jdbchomework.console.ConsoleMain;
import jdbchomework.console.ContentsUserMenu;
import jdbchomework.console.VisualUserMenu;
import jdbchomework.controller.CompanyController;
import jdbchomework.controller.CustomerController;
import jdbchomework.controller.DeveloperController;
import jdbchomework.controller.ProjectController;
import jdbchomework.controller.SkillController;
import jdbchomework.dao.jdbc.CompaniesJdbcDao;
import jdbchomework.dao.jdbc.CustomersJdbcDao;
import jdbchomework.dao.jdbc.DevelopersJdbcDao;
import jdbchomework.dao.jdbc.ProjectsJdbcDao;
import jdbchomework.dao.jdbc.SkillsJdbcDao;
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

public class Injector {

    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static CompaniesJdbcDao companiesJdbcDao = new CompaniesJdbcDao(sessionFactory, "Company", Company.class);
    private static CustomersJdbcDao customersJdbcDao = new CustomersJdbcDao(sessionFactory,"Customer", Customer.class);
    private static DevelopersJdbcDao developersJdbcDao = new DevelopersJdbcDao(sessionFactory,"Developer", Developer.class);
    private static ProjectsJdbcDao projectsJdbcDao = new ProjectsJdbcDao(sessionFactory, "Project", Project.class);
    private static SkillsJdbcDao skillsJdbcDao = new SkillsJdbcDao(sessionFactory,"Skill", Skill.class);
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

    public static ConsoleMain getConsoleMain() {
        return consoleMain;
    }
}
