package jdbchomework.console;

public class MainMenu extends AbstractMenu {

    public static final String THANK_YOU_FOR_USING_OUR_SERVICE = "\tThank you for using our service.";

    private CompaniesMenu companiesMenu;
    private CustomersMenu customersMenu;
    private DevelopersMenu developersMenu;
    private ProjectsMenu projectsMenu;
    private SkillsMenu skillsMenu;

    public MainMenu(MenuContents menuContents, CompaniesMenu companiesMenu, CustomersMenu customersMenu,
                    DevelopersMenu developersMenu, ProjectsMenu projectsMenu, SkillsMenu skillsMenu) {
        super(menuContents);
        this.menuContents = menuContents;
        this.companiesMenu = companiesMenu;
        this.customersMenu = customersMenu;
        this.developersMenu = developersMenu;
        this.projectsMenu = projectsMenu;
        this.skillsMenu = skillsMenu;
    }

    public void menu() {
        printListInConsole(menuContents.getSiteHeader(), null);
        boolean loopMenu = true;
        while (loopMenu) {
            printListInConsole(menuContents.getServiceHeader(), menuContents.getServiceMainMenu());
            int action = readInt(CHOOSE_ACTION);
            switch (action) {
                case 1:
                    System.out.println(SPLIT_LINE);
                    companiesMenu.menu();
                    break;
                case 2:
                    System.out.println(SPLIT_LINE);
                    customersMenu.menu();
                    break;
                case 3:
                    System.out.println(SPLIT_LINE);
                    developersMenu.menu();
                    break;
                case 4:
                    System.out.println(SPLIT_LINE);
                    projectsMenu.menu();
                    break;
                case 5:
                    System.out.println(SPLIT_LINE);
                    skillsMenu.menu();
                    break;
                case 6:
                    System.out.println(SPLIT_LINE);
                    System.out.println(THANK_YOU_FOR_USING_OUR_SERVICE);
                    loopMenu = false;
                    break;
                default:
                    System.out.println(SPLIT_LINE);
                    System.err.println(ERROR_INCORRECT_MENU_ITEM_SELECTED);
            }
        }
    }
}
