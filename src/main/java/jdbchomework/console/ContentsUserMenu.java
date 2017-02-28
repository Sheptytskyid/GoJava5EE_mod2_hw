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
                    VisualUserMenu.printListInConsole(ListMenu.getServiceHeaderCompany(), ListMenu.getServiceCompaniesMenu());
                    break;
                case (2):
                    VisualUserMenu.outputSplitLine();
                    VisualUserMenu.printListInConsole(ListMenu.getServiceHeaderCustomer(), ListMenu.getServiceCustomersMenu());
                    break;
                case (3):
                    VisualUserMenu.outputSplitLine();
                    VisualUserMenu.printListInConsole(ListMenu.getServiceHeaderDeveloper(), ListMenu.getServiceDevelopersMenu());
                    break;
                case (4):
                    VisualUserMenu.outputSplitLine();
                    VisualUserMenu.printListInConsole(ListMenu.getServiceHeaderProject(), ListMenu.getServiceProjectsMenu());
                    break;
                case (5):
                    VisualUserMenu.outputSplitLine();
                    VisualUserMenu.printListInConsole(ListMenu.getServiceHeaderSkill(), ListMenu.getServiceSkillsMenu());
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
}
