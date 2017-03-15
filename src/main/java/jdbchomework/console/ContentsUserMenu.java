package jdbchomework.console;

import jdbchomework.controller.CompanyController;
import jdbchomework.controller.CustomerController;
import jdbchomework.controller.DeveloperController;
import jdbchomework.controller.ProjectController;
import jdbchomework.controller.SkillController;
import jdbchomework.entity.Skill;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ContentsUserMenu {

    public static final String ERROR_INCORRECT_MENU_ITEM_SELECTED = "ERROR: Incorrect menu item selected \n";
    public static final String SKILL_NOT_FOUND = "Skill not found";
    public static final String PROJECT_NOT_FOUND = "Project not found";
    public static final String COMPANY_NOT_FOUND = "Company not found";
    public static final String CUSTOMER_NOT_FOUND = "Customer not found";
    public static final String PLEASE_ENTER_DEVELOPER_ID = "Please enter developer ID: ";
    public static final String DEVELOPER_NOT_FOUND = "Developer not found";
    public static final String PLEASE_ENTER_CUSTOMER_ID = "Please enter customer ID: ";
    public static final String PLEASE_ENTER_CUSTOMER_NAME = "Please enter customer name: ";
    public static final String CHOOSE_ACTION = "Choose action: ";
    public static final String PLEASE_ENTER_DEVELOPER_NAME = "Please enter developer name: ";
    public static final String PLEASE_ENTER_COMPANY_NAME = "Please enter company name: ";
    public static final String PLEASE_ENTER_COMPANY_ID = "Please enter company ID: ";
    public static final String PLEASE_ENTER_PROJECT_NAME = "Please enter project name: ";
    public static final String PLEASE_ENTER_PROJECT_ID = "Please enter project ID: ";
    public static final String PLEASE_ENTER_PROJECT_COST = "Please enter project cost: ";
    public static final String PLEASE_ENTER_SKILL_NAME = "Please enter skill name: ";
    public static final String PLEASE_ENTER_SKILL_ID = "Please enter skill ID: ";
    private static org.slf4j.Logger log = LoggerFactory.getLogger(ContentsUserMenu.class);

    private CompanyController companyController;
    private CustomerController customerController;
    private DeveloperController developerController;
    private ProjectController projectController;
    private SkillController skillController;
    private VisualUserMenu visualUserMenu;

    public ContentsUserMenu(CompanyController companyController, CustomerController customerController,
                            DeveloperController developerController, ProjectController projectController,
                            SkillController skillController, VisualUserMenu visualUserMenu) {
        this.companyController = companyController;
        this.customerController = customerController;
        this.developerController = developerController;
        this.projectController = projectController;
        this.skillController = skillController;
        this.visualUserMenu = visualUserMenu;
    }

    public void mainMenu() {
        mark:
        while (true) {
            VisualUserMenu.printListInConsole(ListMenu.getSiteHeader(), null);
            VisualUserMenu.printListInConsole(ListMenu.getServiceHeader(), ListMenu.getServiceMainMenu());
            Integer action;
            action = Integer.parseInt(visualUserMenu.getValidInputFromUser(CHOOSE_ACTION, InputType.INTEGER));
            switch (action) {
                case (1):
                    VisualUserMenu.outputSplitLine();
                    companyMenu();
                    break;
                case (2):
                    VisualUserMenu.outputSplitLine();
                    customerMenu();
                    break;
                case (3):
                    VisualUserMenu.outputSplitLine();
                    developerMenu();
                    break;
                case (4):
                    VisualUserMenu.outputSplitLine();
                    projectMenu();
                    break;
                case (5):
                    VisualUserMenu.outputSplitLine();
                    skillMenu();
                    return;
                case (6):
                    VisualUserMenu.outputSplitLine();
                    System.out.println("\tThank you for using our service.");
                    break mark;
                default:
                    VisualUserMenu.outputSplitLine();
                    System.out.println(ERROR_INCORRECT_MENU_ITEM_SELECTED);
            }
        }
    }

    private void skillMenu() {
        mark:
        while (true) {
            VisualUserMenu.printListInConsole(ListMenu.getServiceHeaderSkill(),
                ListMenu.getServiceSkillsMenu());
            Integer action;
            action = Integer.parseInt(visualUserMenu.getValidInputFromUser(CHOOSE_ACTION, InputType.INTEGER));
            switch (action) {
                case 1:
                    VisualUserMenu.printListInConsole(null, skillController.getAllSkills());
                    break;
                case 2:
                    String name = visualUserMenu.getValidInputFromUser(PLEASE_ENTER_SKILL_NAME, InputType.STRING);
                    skillController.addSkill(name);
                    System.out.println(name + " successfully added");
                    break;
                case 3:
                    int id = Integer.parseInt(visualUserMenu
                        .getValidInputFromUser(PLEASE_ENTER_SKILL_ID, InputType.INTEGER));
                    System.out.println(skillController.getSkillById(id));
                    break;
                case 4:
                    id = Integer.parseInt(visualUserMenu
                        .getValidInputFromUser(PLEASE_ENTER_SKILL_ID, InputType.INTEGER));
                    name = visualUserMenu.getValidInputFromUser(PLEASE_ENTER_SKILL_NAME, InputType.STRING);
                    if (skillController.updateSkillById(id, name)) {
                        System.out.println("Skill successfully updated");
                    } else {
                        System.out.println(SKILL_NOT_FOUND);
                    }
                    break;
                case 5:
                    id = Integer.parseInt(visualUserMenu
                        .getValidInputFromUser(PLEASE_ENTER_SKILL_ID, InputType.INTEGER));
                    if (skillController.deleteSkillById(id)) {
                        System.out.println("Skill successfully deleted");
                    } else {
                        System.out.println(SKILL_NOT_FOUND);
                    }
                    break;
                case (6):
                    VisualUserMenu.outputSplitLine();
                    break mark;
                default:
                    VisualUserMenu.outputSplitLine();
                    System.out.println(ERROR_INCORRECT_MENU_ITEM_SELECTED);
            }
        }
    }

    private void projectMenu() {
        mark:
        while (true) {
            VisualUserMenu.printListInConsole(ListMenu.getServiceHeaderProject(),
                ListMenu.getServiceProjectsMenu());
            Integer action;
            action = Integer.parseInt(visualUserMenu.getValidInputFromUser(CHOOSE_ACTION, InputType.INTEGER));
            switch (action) {
                case 1:
                    VisualUserMenu.printListInConsole(null, projectController.getAllProjects());
                    break;
                case 2:
                    String name = visualUserMenu
                        .getValidInputFromUser(PLEASE_ENTER_PROJECT_NAME, InputType.STRING);
                    int cost = Integer.parseInt(visualUserMenu
                        .getValidInputFromUser(PLEASE_ENTER_PROJECT_COST, InputType.INTEGER));
                    projectController.addProject(name, cost);
                    System.out.println("Project successfully added");
                    break;
                case 3:
                    int id = Integer.parseInt(visualUserMenu
                        .getValidInputFromUser(PLEASE_ENTER_PROJECT_ID, InputType.INTEGER));
                    System.out.println(projectController.getProjectById(id));
                    break;
                case 4:
                    id = Integer.parseInt(visualUserMenu
                        .getValidInputFromUser(PLEASE_ENTER_PROJECT_ID, InputType.INTEGER));
                    name = visualUserMenu.getValidInputFromUser(PLEASE_ENTER_PROJECT_NAME, InputType.STRING);
                    cost = Integer.parseInt(visualUserMenu
                        .getValidInputFromUser(PLEASE_ENTER_PROJECT_COST, InputType.INTEGER));
                    if (projectController.updateProjectById(id, name, cost)) {
                        System.out.println("Project successfully updated");
                    } else {
                        System.out.println(PROJECT_NOT_FOUND);
                    }
                    break;
                case 5:
                    id = Integer.parseInt(visualUserMenu
                        .getValidInputFromUser(PLEASE_ENTER_PROJECT_ID, InputType.INTEGER));
                    if (projectController.deleteProjectById(id)) {
                        System.out.println("Project successfully deleted");
                    } else {
                        System.out.println(PROJECT_NOT_FOUND);
                    }
                    break;
                case (6):
                    VisualUserMenu.outputSplitLine();
                    break mark;
                default:
                    VisualUserMenu.outputSplitLine();
                    System.out.println(ERROR_INCORRECT_MENU_ITEM_SELECTED);
            }
        }
    }

    public void companyMenu() {
        mark:
        while (true) {
            VisualUserMenu.printListInConsole(ListMenu.getServiceHeaderCompany(), ListMenu.getServiceCompaniesMenu());
            Integer action;
            action = Integer.parseInt(visualUserMenu.getValidInputFromUser(CHOOSE_ACTION, InputType.INTEGER));
            switch (action) {
                case 1:
                    VisualUserMenu.printListInConsole(null, companyController.getAllCompanies());
                    break;
                case 2:
                    String name = visualUserMenu.getValidInputFromUser(PLEASE_ENTER_COMPANY_NAME, InputType.STRING);
                    companyController.addCompany(name);
                    System.out.println("Company successfully added");
                    break;
                case 3:
                    int id = Integer.parseInt(visualUserMenu
                        .getValidInputFromUser(PLEASE_ENTER_COMPANY_ID, InputType.INTEGER));
                    System.out.println(companyController.getCompanyById(id));
                    break;

                case 4:
                    id = Integer.parseInt(visualUserMenu.getValidInputFromUser(PLEASE_ENTER_COMPANY_ID, InputType.INTEGER));
                    companyController.getAllCompanyDevelopers(id).forEach(System.out::println);
                    break;
                case 5:
                    id = Integer.parseInt(visualUserMenu
                        .getValidInputFromUser(PLEASE_ENTER_COMPANY_ID, InputType.INTEGER));
                    name = visualUserMenu.getValidInputFromUser(PLEASE_ENTER_COMPANY_NAME, InputType.STRING);
                    if (companyController.updateCompanyById(id, name)) {
                        System.out.println("Company successfully updated");
                    } else {
                        System.out.println(COMPANY_NOT_FOUND);
                    }
                    break;
                case 6:
                    id = Integer.parseInt(visualUserMenu
                        .getValidInputFromUser(PLEASE_ENTER_COMPANY_ID, InputType.INTEGER));
                    if (companyController.deleteCompanyById(id)) {
                        System.out.println("Company successfully deleted");
                    } else {
                        System.out.println(COMPANY_NOT_FOUND);
                    }
                    break;
                case (7):
                    VisualUserMenu.outputSplitLine();
                    break mark;
                default:
                    VisualUserMenu.outputSplitLine();
                    System.out.println(ERROR_INCORRECT_MENU_ITEM_SELECTED);
            }
        }
    }

    public void customerMenu() {
        mark:
        while (true) {
            VisualUserMenu.printListInConsole(ListMenu.getServiceHeaderCustomer(),
                ListMenu.getServiceCustomersMenu());
            Integer action;
            action = Integer.parseInt(visualUserMenu.getValidInputFromUser(CHOOSE_ACTION, InputType.INTEGER));
            switch (action) {
                case 1:
                    VisualUserMenu.printListInConsole(null, customerController.getAllCustomers());
                    break;
                case 2:
                    String name = visualUserMenu.getValidInputFromUser(PLEASE_ENTER_CUSTOMER_NAME, InputType.STRING);
                    customerController.addCustomer(name);
                    System.out.println("Customer successfully added");
                    break;
                case 3:
                    int id = Integer.parseInt(visualUserMenu
                        .getValidInputFromUser(PLEASE_ENTER_CUSTOMER_ID, InputType.INTEGER));
                    System.out.println(customerController.getCustomerById(id));
                    break;
                case 4:
                    id = Integer.parseInt(visualUserMenu
                        .getValidInputFromUser(PLEASE_ENTER_CUSTOMER_ID, InputType.INTEGER));
                    name = visualUserMenu.getValidInputFromUser(PLEASE_ENTER_CUSTOMER_NAME, InputType.STRING);
                    if (customerController.updateCustomerById(id, name)) {
                        System.out.println("Customer successfully updated");
                    } else {
                        System.out.println(CUSTOMER_NOT_FOUND);
                    }
                    break;
                case 5:
                    id = Integer.parseInt(visualUserMenu
                        .getValidInputFromUser(PLEASE_ENTER_CUSTOMER_ID, InputType.INTEGER));
                    if (customerController.deleteCustomerById(id)) {
                        System.out.println("Customer successfully deleted");
                    } else {
                        System.out.println(CUSTOMER_NOT_FOUND);
                    }
                    break;
                case (6):
                    VisualUserMenu.outputSplitLine();
                    break mark;
                default:
                    VisualUserMenu.outputSplitLine();
                    System.out.println(ERROR_INCORRECT_MENU_ITEM_SELECTED);
            }
        }
    }

    public void developerMenu() {
        mark:
        while (true) {
            VisualUserMenu.printListInConsole(ListMenu.getServiceHeaderDeveloper(),
                ListMenu.getServiceDevelopersMenu());
            Integer action;
            action = Integer.parseInt(visualUserMenu.getValidInputFromUser(CHOOSE_ACTION, InputType.INTEGER));
            switch (action) {
                case 1:
                    VisualUserMenu.printListInConsole(null, developerController.getAllDevelopers());
                    break;
                case 2:
                    String name = visualUserMenu.getValidInputFromUser(PLEASE_ENTER_DEVELOPER_NAME, InputType.STRING);
                    developerController.addDeveloper(name);
                    System.out.println("Developer successfully added");
                    break;
                case 3:
                    int id = Integer.parseInt(visualUserMenu
                        .getValidInputFromUser(PLEASE_ENTER_DEVELOPER_ID, InputType.INTEGER));
                    System.out.println(developerController.getDeveloperById(id));
                    break;
                case 4:
                    id = Integer.parseInt(visualUserMenu
                        .getValidInputFromUser(PLEASE_ENTER_DEVELOPER_ID, InputType.INTEGER));
                    name = visualUserMenu.getValidInputFromUser(PLEASE_ENTER_DEVELOPER_NAME, InputType.STRING);
                    List<Skill> skills = Arrays.stream(visualUserMenu.getValidInputFromUser(
                        "Please enter skill IDs separated by spaces", InputType.STRING).split(" "))
                        .map(skillId -> skillController.getSkillById(Integer.valueOf(skillId)))
                        .collect(Collectors.toList());
                    if (developerController.updateDeveloperById(id, name, skills)) {
                        System.out.println("Developer successfully updated");
                    } else {
                        System.out.println(DEVELOPER_NOT_FOUND);
                    }
                    break;
                case 5:
                    id = Integer.parseInt(visualUserMenu
                        .getValidInputFromUser(PLEASE_ENTER_DEVELOPER_ID, InputType.INTEGER));
                    if (developerController.deleteDeveloperById(id)) {
                        System.out.println("Developer successfully deleted");
                    } else {
                        System.out.println(DEVELOPER_NOT_FOUND);
                    }
                    break;
                case (6):
                    VisualUserMenu.outputSplitLine();
                    break mark;
                default:
                    VisualUserMenu.outputSplitLine();
                    System.out.println(ERROR_INCORRECT_MENU_ITEM_SELECTED);
            }
        }
    }
}
