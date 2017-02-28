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
        VisualUserMenu.printListInConsole(ListMenu.getServiceHeaderSkill(),
                ListMenu.getServiceSkillsMenu());

    }

    private void projectMenu() {
        VisualUserMenu.printListInConsole(ListMenu.getServiceHeaderProject(),
                ListMenu.getServiceProjectsMenu());
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
        VisualUserMenu.printListInConsole(ListMenu.getServiceHeaderCustomer(),
                ListMenu.getServiceCustomersMenu());
    }

    public void developerMenu() {
        VisualUserMenu.printListInConsole(ListMenu.getServiceHeaderDeveloper(),
                ListMenu.getServiceDevelopersMenu());
    }
}
