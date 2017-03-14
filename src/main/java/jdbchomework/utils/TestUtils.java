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
    public static final String SOME_NAME = "Name for all cases";
    public static final Company COMPANY_RESULT = new Company(SOME_NAME);
    public static final Customer CUSTOMER_RESULT = new Customer(SOME_NAME);
    public static final Developer DEVELOPER_RESULT = new Developer(SOME_NAME);
    public static final Project PROJECT_RESULT = new Project(SOME_NAME, COST);
    public static final Skill SKILL_RESULT = new Skill(SOME_NAME);
    public static final List<Company> ALL_COMPANIES = Arrays.asList(new Company(SOME_NAME),
            new Company(SOME_NAME), new Company(SOME_NAME));
    public static final List<Customer> ALL_CUSTOMERS = Arrays.asList(new Customer(SOME_NAME),
            new Customer(SOME_NAME), new Customer(SOME_NAME));
    public static final List<Developer> ALL_DEVELOPERS = Arrays.asList(new Developer(SOME_NAME),
            new Developer(SOME_NAME), new Developer(SOME_NAME));
    public static final List<Project> ALL_PROJECTS = Arrays.asList(new Project(SOME_NAME, COST),
            new Project(SOME_NAME, COST), new Project(SOME_NAME, COST));

    public static final List<Skill> ALL_SKILLS = Arrays.asList(new Skill(SOME_NAME),
            new Skill(SOME_NAME), new Skill(SOME_NAME));

    private TestUtils() {
        throw new IllegalAccessError("Utility class");
    }
}
