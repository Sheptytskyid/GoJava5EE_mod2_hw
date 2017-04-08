package jdbchomework.console;

import jdbchomework.controller.SkillController;

public class SkillsMenu extends AbstractMenu {

    private static final String SKILL_NOT_FOUND = "Skill not found";
    private static final String PLEASE_ENTER_SKILL_NAME = "Please enter skill name: ";
    private static final String PLEASE_ENTER_SKILL_ID = "Please enter skill ID: ";

    private SkillController skillController;

    public SkillsMenu(MenuContents menuContents, SkillController skillController) {
        super(menuContents);
        this.menuContents = menuContents;
        this.skillController = skillController;
    }

    public void menu() {
        boolean loopMenu = true;
        while (loopMenu) {
            printListInConsole(menuContents.getServiceHeaderSkill(),
                menuContents.getServiceSkillsMenu());
            int action = readInt(CHOOSE_ACTION);
            switch (action) {
                case 1:
                    printListInConsole(null, skillController.getAllSkills());
                    break;
                case 2:
                    String name = readString(PLEASE_ENTER_SKILL_NAME);
                    skillController.addSkill(name);
                    System.out.println(name + " successfully added");
                    break;
                case 3:
                    int id = readInt(PLEASE_ENTER_SKILL_ID);
                    System.out.println(skillController.getSkillById(id));
                    break;
                case 4:
                    id = readInt(PLEASE_ENTER_SKILL_ID);
                    name = readString(PLEASE_ENTER_SKILL_NAME);
                    if (skillController.updateSkillById(id, name)) {
                        System.out.println("Skill successfully updated");
                    } else {
                        System.err.println(SKILL_NOT_FOUND);
                    }
                    break;
                case 5:
                    id = readInt(PLEASE_ENTER_SKILL_ID);
                    if (skillController.deleteSkillById(id)) {
                        System.out.println("Skill successfully deleted");
                    } else {
                        System.err.println(SKILL_NOT_FOUND);
                    }
                    break;
                case 6:
                    System.out.println(SPLIT_LINE);
                    loopMenu = false;
                    break;
                default:
                    System.out.println(SPLIT_LINE);
                    System.err.println(ERROR_INCORRECT_MENU_ITEM_SELECTED);
            }
        }
    }
}
