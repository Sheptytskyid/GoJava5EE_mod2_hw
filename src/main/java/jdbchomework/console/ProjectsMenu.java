package jdbchomework.console;

import jdbchomework.controller.ProjectController;
import org.slf4j.LoggerFactory;

public class ProjectsMenu extends AbstractMenu {

    private static final String PROJECT_NOT_FOUND = "Project not found";
    private static final String PLEASE_ENTER_PROJECT_NAME = "Please enter project name: ";
    private static final String PLEASE_ENTER_PROJECT_ID = "Please enter project ID: ";
    private static final String PLEASE_ENTER_PROJECT_COST = "Please enter project cost: ";

    private ProjectController projectController;

    public ProjectsMenu(MenuContents menuContents, ProjectController projectController) {
        super(LoggerFactory.getLogger(ProjectsMenu.class), menuContents);
        this.menuContents = menuContents;
        this.projectController = projectController;
    }

    public void menu() {
        while (true) {
            printListInConsole(menuContents.getServiceHeaderProject(), menuContents.getServiceProjectsMenu());
            int action = readInt(CHOOSE_ACTION);
            switch (action) {
                case 1:
                    printListInConsole(null, projectController.getAllProjects());
                    break;
                case 2:
                    String name = readString(PLEASE_ENTER_PROJECT_NAME);
                    int cost = readInt(PLEASE_ENTER_PROJECT_COST);
                    projectController.addProject(name, cost);
                    System.out.println("Project successfully added");
                    break;
                case 3:
                    int id = readInt(PLEASE_ENTER_PROJECT_ID);
                    System.out.println(projectController.getProjectById(id));
                    break;
                case 4:
                    id = readInt(PLEASE_ENTER_PROJECT_ID);
                    name = readString(PLEASE_ENTER_PROJECT_NAME);
                    cost = readInt(PLEASE_ENTER_PROJECT_COST);
                    if (projectController.updateProjectById(id, name, cost)) {
                        System.out.println("Project successfully updated");
                    } else {
                        System.err.println(PROJECT_NOT_FOUND);
                    }
                    break;
                case 5:
                    id = readInt(PLEASE_ENTER_PROJECT_ID);
                    if (projectController.deleteProjectById(id)) {
                        System.out.println("Project successfully deleted");
                    } else {
                        System.err.println(PROJECT_NOT_FOUND);
                    }
                    break;
                case 6:
                    printSplitLine();
                    return;
                default:
                    printSplitLine();
                    System.err.println(ERROR_INCORRECT_MENU_ITEM_SELECTED);
            }
        }
    }
}
