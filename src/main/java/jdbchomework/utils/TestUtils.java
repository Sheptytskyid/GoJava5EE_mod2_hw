package jdbchomework.utils;

import jdbchomework.entity.Company;

import java.util.Arrays;
import java.util.List;

public class TestUtils {

    public static final List<Company> ALL_COMPANIES = Arrays.asList(new Company("Test1"),
            new Company("Test2"), new Company("Test3"));
    public static final int ID = 111;
    public static final String COMPANY_NAME = "Comp&Co";
    public static final Company COMPANY_RESULT = new Company(COMPANY_NAME);


//    private jdbchomework.utils.TestUtils() {
//        throw new IllegalAccessError("Utility class");
//    }
}
