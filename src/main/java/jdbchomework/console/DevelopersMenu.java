package jdbchomework.console;

import jdbchomework.controller.DeveloperController;
import jdbchomework.controller.SkillController;
import jdbchomework.entity.Skill;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DevelopersMenu extends AbstractMenu {

    private static final String PLEASE_ENTER_DEVELOPER_ID = "Please enter developer ID: ";
    private static final String DEVELOPER_NOT_FOUND = "Developer not found";
    private static final String PLEASE_ENTER_DEVELOPER_NAME = "Please enter developer name: ";

    private DeveloperController developerController;
    private SkillController skillController;

    public DevelopersMenu(MenuContents menuContents, DeveloperController developerController,
                          SkillController skillController) {
        super(LoggerFactory.getLogger(DevelopersMenu.class), menuContents);
        this.menuContents = menuContents;
        this.developerController = developerController;
        this.skillController = skillController;
    }

    public void menu() {
        mark:
        while (true) {
            printListInConsole(menuContents.getServiceHeaderDeveloper(),
                menuContents.getServiceDevelopersMenu());
            int action = readInt(CHOOSE_ACTION);
            switch (action) {
                case 1:
                    printListInConsole(null, developerController.getAllDevelopers());
                    break;
                case 2:
                    String name = readString(PLEASE_ENTER_DEVELOPER_NAME);
                    List<Skill> skills = readList();
                    developerController.addDeveloper(name, skills);
                    System.out.println("Developer successfully added");
                    break;
                case 3:
                    int id = readInt(PLEASE_ENTER_DEVELOPER_ID);
                    System.out.println(developerController.getDeveloperById(id));
                    break;
                case 4:
                    id = readInt(PLEASE_ENTER_DEVELOPER_ID);
                    name = readString(PLEASE_ENTER_DEVELOPER_NAME);
                    skills = readList();
                    if (developerController.updateDeveloperById(id, name, skills)) {
                        System.out.println("Developer successfully updated");
                    } else {
                        System.out.println(DEVELOPER_NOT_FOUND);
                    }
                    break;
                case 5:
                    id = readInt(PLEASE_ENTER_DEVELOPER_ID);
                    if (developerController.deleteDeveloperById(id)) {
                        System.out.println("Developer successfully deleted");
                    } else {
                        System.out.println(DEVELOPER_NOT_FOUND);
                    }
                    break;
                case (6):
                    printSplitLine();;
                    break mark;
                default:
                    printSplitLine();
                    System.out.println(ERROR_INCORRECT_MENU_ITEM_SELECTED);
            }
        }
    }

    private List<Skill> readList() {
        return Arrays.stream(getValidInputFromUser(
                            "Please enter skill IDs separated by spaces", InputType.LIST).split(" "))
                            .map(skillId -> skillController.getSkillById(Integer.valueOf(skillId)))
                            .collect(Collectors.toList());
    }
}
