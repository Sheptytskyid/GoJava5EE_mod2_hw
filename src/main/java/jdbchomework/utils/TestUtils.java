package jdbchomework.utils;

import jdbchomework.entity.Company;
import jdbchomework.entity.Customer;
import jdbchomework.entity.Developer;
import jdbchomework.entity.Project;
import jdbchomework.entity.Skill;

import java.util.Arrays;
import java.util.List;

public class TestUtils {

    public static final int ID = 111;
    public static final int COST = 12345;
    public static final String DEVELOPER_NAME = "Name ";
    public static final String COMPANY_NAME = "Company name";
    public static final String CUSTOMER_NAME = "Customer name";
    public static final String PROJECT_NAME = "Project name";
    public static final String SKILL_NAME = "Skill name";
    public static final Company COMPANY_RESULT = new Company(COMPANY_NAME);
    public static final Customer CUSTOMER_RESULT = new Customer(CUSTOMER_NAME);
    public static final Developer DEVELOPER_RESULT = new Developer(DEVELOPER_NAME);
    public static final Project PROJECT_RESULT = new Project(PROJECT_NAME, COST);
    public static final Skill SKILL_RESULT = new Skill(SKILL_NAME);
    public static final List<Company> ALL_COMPANIES = Arrays.asList(new Company(COMPANY_NAME),
            new Company(COMPANY_NAME), new Company(COMPANY_NAME));
    public static final List<Customer> ALL_CUSTOMERS = Arrays.asList(new Customer(CUSTOMER_NAME),
            new Customer(CUSTOMER_NAME), new Customer(CUSTOMER_NAME));
    public static final List<Developer> ALL_DEVELOPERS = Arrays.asList(new Developer(DEVELOPER_NAME),
            new Developer(DEVELOPER_NAME), new Developer(DEVELOPER_NAME));
    public static final List<Project> ALL_PROJECTS = Arrays.asList(new Project(PROJECT_NAME, COST),
            new Project(PROJECT_NAME, COST), new Project(PROJECT_NAME, COST));

    public static final List<Skill> ALL_SKILLS = Arrays.asList(new Skill(SKILL_NAME),
            new Skill(SKILL_NAME), new Skill(SKILL_NAME));

    private TestUtils() {
        throw new IllegalAccessError("Utility class");
    }
}
