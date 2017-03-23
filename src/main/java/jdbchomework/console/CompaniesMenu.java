package jdbchomework.console;

import jdbchomework.controller.CompanyController;
import jdbchomework.controller.ProjectController;
import jdbchomework.entity.Project;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CompaniesMenu extends AbstractMenu {

    private static final String COMPANY_NOT_FOUND = "Company not found";
    private static final String PLEASE_ENTER_COMPANY_NAME = "Please enter company name: ";
    private static final String PLEASE_ENTER_COMPANY_ID = "Please enter company ID: ";

    private CompanyController companyController;
    private ProjectController projectController;

    public CompaniesMenu(MenuContents menuContents, CompanyController companyController, ProjectController
        projectController) {
        super(menuContents);
        this.companyController = companyController;
        this.projectController = projectController;
    }

    public void menu() {
        boolean loopMenu = true;
        while (loopMenu) {
            printListInConsole(menuContents.getServiceHeaderCompany(), menuContents.getServiceCompaniesMenu());
            int action = readInt(CHOOSE_ACTION);
            switch (action) {
                case 1:
                    printListInConsole(null, companyController.getAllCompanies());
                    break;
                case 2:
                    String name = readString(PLEASE_ENTER_COMPANY_NAME);
                    List<Project> projects = readList();
                    companyController.addCompany(name, projects);
                    System.out.println("Company successfully added");
                    break;
                case 3:
                    int id = readInt(PLEASE_ENTER_COMPANY_ID);
                    System.out.println(companyController.getCompanyById(id));
                    break;
                case 4:
                    id = readInt(PLEASE_ENTER_COMPANY_ID);
                    companyController.getAllCompanyDevelopers(id).forEach(System.out::println);
                    break;
                case 5:
                    id = readInt(PLEASE_ENTER_COMPANY_ID);
                    name = readString(PLEASE_ENTER_COMPANY_NAME);
                    projects = readList();
                    if (companyController.updateCompanyById(id, name, projects)) {
                        System.out.println("Company successfully updated");
                    } else {
                        System.out.println(COMPANY_NOT_FOUND);
                    }
                    break;
                case 6:
                    id = readInt(PLEASE_ENTER_COMPANY_ID);
                    if (companyController.deleteCompanyById(id)) {
                        System.out.println("Company successfully deleted");
                    } else {
                        System.out.println(COMPANY_NOT_FOUND);
                    }
                    break;
                case 7:
                    System.out.println(SPLIT_LINE);
                    loopMenu = false;
                    break;
                default:
                    System.out.println(SPLIT_LINE);
                    System.out.println(ERROR_INCORRECT_MENU_ITEM_SELECTED);
            }
        }
    }

    private List<Project> readList() {
        List<Project> projects;
        projects = Arrays.stream(getValidInputFromUser(
            "Please enter project IDs separated by spaces", InputType.LIST).split(" "))
            .map(projectId -> projectController.getProjectById(Integer.valueOf(projectId)))
            .collect(Collectors.toList());
        return projects;
    }
}
