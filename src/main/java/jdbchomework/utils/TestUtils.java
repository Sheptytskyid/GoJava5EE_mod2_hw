package jdbchomework.utils;

import jdbchomework.entity.*;

import java.util.Arrays;
import java.util.List;

public class TestUtils {


    public static final int ID = 111;
    public static final int COST = 12345;
    public static final String NAME = "Name for all cases";
    public static final Company COMPANY_RESULT = new Company(NAME);
    public static final Customer CUSTOMER_RESULT = new Customer(NAME);
    public static final Developer DEVELOPER_RESULT = new Developer(NAME);
    public static final Project PROJECT_RESULT = new Project(NAME, COST);
    public static final Skill SKILL_RESULT = new Skill(NAME);
    public static final List<Company> ALL_COMPANIES = Arrays.asList(new Company(NAME),
            new Company(NAME), new Company(NAME));
    public static final List<Customer> ALL_CUSTOMERS = Arrays.asList(new Customer(NAME),
            new Customer(NAME), new Customer(NAME));

//    private jdbchomework.utils.TestUtils() {
//        throw new IllegalAccessError("Utility class");
//    }
}
