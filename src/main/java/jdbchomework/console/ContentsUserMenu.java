package jdbchomework.console;

import jdbchomework.controller.CompanyController;
import jdbchomework.controller.CustomerController;
import jdbchomework.controller.DeveloperController;
import jdbchomework.controller.ProjectController;
import jdbchomework.controller.SkillController;
import org.slf4j.LoggerFactory;

public class ContentsUserMenu {

    public static final String ERROR_INCORRECT_MENU_ITEM_SELECTED = "ERROR: Incorrect menu item selected \n";
    public static final String ERROR_INVALID_NAME_FORMAT = "ERROR: Invalid name format!\n";
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
        while (true) {
            VisualUserMenu.printListInConsole(ListMenu.getServiceHeader(), ListMenu.getServiceMainMenu());
            Integer action;
            action = Integer.parseInt(visualUserMenu.getValidInputFromUser("Choose action: ", InputType.INTEGER));
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
                    System.exit(0);
                    break;
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
            action = Integer.parseInt(visualUserMenu.getValidInputFromUser("Choose action: ", InputType.INTEGER));
            switch (action) {
                case 1:
                    VisualUserMenu.printListInConsole(null, skillController.getAll());
                    break;
                case 2:
                    String name = visualUserMenu.getValidInputFromUser("Please enter skill name: ", InputType.STRING);
                    skillController.add(name);
                    break;
                case 3:
                    int id = Integer.parseInt(visualUserMenu
                            .getValidInputFromUser("Please enter skill ID: ", InputType.INTEGER));
                    System.out.println(skillController.getById(id));
                    break;
                case 4:
                    id = Integer.parseInt(visualUserMenu
                            .getValidInputFromUser("Please enter skill ID: ", InputType.INTEGER));
                    name = visualUserMenu.getValidInputFromUser("Please enter skill name: ", InputType.STRING);
                    skillController.updateById(id, name);
                    break;
                case 5:
                    id = Integer.parseInt(visualUserMenu
                            .getValidInputFromUser("Please enter skill ID: ", InputType.INTEGER));
                    skillController.deleteById(id);
                    break;
                case (6):
                    VisualUserMenu.outputSplitLine();
                    System.out.println("\tThank you! for using our service.");
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
            action = Integer.parseInt(visualUserMenu.getValidInputFromUser("Choose action: ", InputType.INTEGER));
            switch (action) {
                case 1:
                    VisualUserMenu.printListInConsole(null, projectController.getAll());
                    break;
                case 2:
                    String name = visualUserMenu
                            .getValidInputFromUser("Please enter project name: ", InputType.STRING);
                    int cost = Integer.parseInt(visualUserMenu
                            .getValidInputFromUser("Please enter project cost: ", InputType.INTEGER));
                    projectController.add(name, cost);
                    break;
                case 3:
                    int id = Integer.parseInt(visualUserMenu
                            .getValidInputFromUser("Please enter project ID: ", InputType.INTEGER));
                    System.out.println(projectController.getById(id));
                    break;
                case 4:
                    id = Integer.parseInt(visualUserMenu
                            .getValidInputFromUser("Please enter project ID: ", InputType.INTEGER));
                    name = visualUserMenu.getValidInputFromUser("Please enter project name: ", InputType.STRING);
                    cost = Integer.parseInt(visualUserMenu
                            .getValidInputFromUser("Please enter project cost: ", InputType.INTEGER));
                    projectController.updateById(id, name, cost);
                    break;
                case 5:
                    id = Integer.parseInt(visualUserMenu
                            .getValidInputFromUser("Please enter project ID: ", InputType.INTEGER));
                    projectController.deleteById(id);
                    break;
                case (6):
                    VisualUserMenu.outputSplitLine();
                    System.out.println("\tThank you! for using our service.");
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
            action = Integer.parseInt(visualUserMenu.getValidInputFromUser("Choose action: ", InputType.INTEGER));
            switch (action) {
                case 1:
                    VisualUserMenu.printListInConsole(null, companyController.getAll());
                    break;
                case 2:
                    String name = visualUserMenu.getValidInputFromUser("Please enter company name: ", InputType.STRING);
                    companyController.add(name);
                    break;
                case 3:
                    int id = Integer.parseInt(visualUserMenu
                            .getValidInputFromUser("Please enter company ID: ", InputType.INTEGER));
                    System.out.println(companyController.getById(id));
                    break;
                case 4:
                    id = Integer.parseInt(visualUserMenu
                            .getValidInputFromUser("Please enter company ID: ", InputType.INTEGER));
                    name = visualUserMenu.getValidInputFromUser("Please enter company name: ", InputType.STRING);
                    companyController.updateById(id, name);
                    break;
                case 5:
                    id = Integer.parseInt(visualUserMenu
                            .getValidInputFromUser("Please enter company ID: ", InputType.INTEGER));
                    companyController.deleteById(id);
                    break;
                case (6):
                    VisualUserMenu.outputSplitLine();
                    System.out.println("\tThank you! for using our service.");
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
            action = Integer.parseInt(visualUserMenu.getValidInputFromUser("Choose action: ", InputType.INTEGER));
            switch (action) {
                case 1:
                    VisualUserMenu.printListInConsole(null, customerController.getAll());
                    break;
                case 2:
                    String name = visualUserMenu.getValidInputFromUser("Please enter customer name: ", InputType.STRING);
                    customerController.add(name);
                    break;
                case 3:
                    int id = Integer.parseInt(visualUserMenu
                            .getValidInputFromUser("Please enter customer ID: ", InputType.INTEGER));
                    System.out.println(customerController.getById(id));
                    break;
                case 4:
                    id = Integer.parseInt(visualUserMenu
                            .getValidInputFromUser("Please enter customer ID: ", InputType.INTEGER));
                    name = visualUserMenu.getValidInputFromUser("Please enter customer name: ", InputType.STRING);
                    customerController.updateById(id, name);
                    break;
                case 5:
                    id = Integer.parseInt(visualUserMenu
                            .getValidInputFromUser("Please enter customer ID: ", InputType.INTEGER));
                    customerController.deleteById(id);
                    break;
                case (6):
                    VisualUserMenu.outputSplitLine();
                    System.out.println("\tThank you! for using our service.");
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
            action = Integer.parseInt(visualUserMenu.getValidInputFromUser("Choose action: ", InputType.INTEGER));
            switch (action) {
                case 1:
                    VisualUserMenu.printListInConsole(null, developerController.getAll());
                    break;
                case 2:
                    String name = visualUserMenu.getValidInputFromUser("Please enter developer name: ", InputType.STRING);
                    developerController.add(name);
                    break;
                case 3:
                    int id = Integer.parseInt(visualUserMenu
                            .getValidInputFromUser("Please enter developer ID: ", InputType.INTEGER));
                    System.out.println(developerController.getById(id));
                    break;
                case 4:
                    id = Integer.parseInt(visualUserMenu
                            .getValidInputFromUser("Please enter developer ID: ", InputType.INTEGER));
                    name = visualUserMenu.getValidInputFromUser("Please enter developer name: ", InputType.STRING);
                    developerController.updateById(id, name);
                    break;
                case 5:
                    id = Integer.parseInt(visualUserMenu
                            .getValidInputFromUser("Please enter developer ID: ", InputType.INTEGER));
                    developerController.deleteById(id);
                    break;
                case (6):
                    VisualUserMenu.outputSplitLine();
                    System.out.println("\tThank you! for using our service.");
                    break mark;
                default:
                    VisualUserMenu.outputSplitLine();
                    System.out.println(ERROR_INCORRECT_MENU_ITEM_SELECTED);
            }
        }
    }
}
