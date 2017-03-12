import jdbchomework.controller.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.runners.Suite.*;

@RunWith(Suite.class)
@SuiteClasses({
        CompanyControllerTest.class,
        CustomerControllerTest.class,
        DeveloperControllerTest.class,
        ProjectControllerTest.class,
        SkillControllerTest.class
})
public class TestRunner {
}
