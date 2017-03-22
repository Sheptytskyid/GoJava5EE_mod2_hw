package jdbchomework.console;

import org.slf4j.LoggerFactory;

public class MainMenu extends AbstractMenu {

    public static final String THANK_YOU_FOR_USING_OUR_SERVICE = "\tThank you for using our service.";

    private CompaniesMenu companiesMenu;
    private CustomersMenu customersMenu;
    private DevelopersMenu developersMenu;
    private ProjectsMenu projectsMenu;
    private SkillsMenu skillsMenu;

    public MainMenu(MenuContents menuContents, CompaniesMenu companiesMenu, CustomersMenu customersMenu,
                    DevelopersMenu developersMenu, ProjectsMenu projectsMenu, SkillsMenu skillsMenu) {
        super(LoggerFactory.getLogger(MainMenu.class), menuContents);
        this.menuContents = menuContents;
        this.companiesMenu = companiesMenu;
        this.customersMenu = customersMenu;
        this.developersMenu = developersMenu;
        this.projectsMenu = projectsMenu;
        this.skillsMenu = skillsMenu;
    }

    public void menu() {
        printListInConsole(menuContents.getSiteHeader(), null);
        mark:
        while (true) {
            printListInConsole(menuContents.getServiceHeader(), menuContents.getServiceMainMenu());
            int action = readInt(CHOOSE_ACTION);
            switch (action) {
                case (1):
                    printSplitLine();
                    companiesMenu.menu();
                    break;
                case (2):
                    printSplitLine();
                    customersMenu.menu();
                    break;
                case (3):
                    printSplitLine();
                    developersMenu.menu();
                    break;
                case (4):
                    printSplitLine();
                    projectsMenu.menu();
                    break;
                case (5):
                    printSplitLine();
                    skillsMenu.menu();
                    break;
                case (6):
                    printSplitLine();
                    System.out.println(THANK_YOU_FOR_USING_OUR_SERVICE);
                    break mark;
                default:
                    printSplitLine();
                    System.out.println(ERROR_INCORRECT_MENU_ITEM_SELECTED);
            }
        }
    }
}
