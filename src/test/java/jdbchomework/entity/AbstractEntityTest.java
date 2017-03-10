package jdbchomework.entity;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class AbstractEntityTest {
    private static final String VALID_NAME = "John";
    private static final long VALID_ID = 123;
    private AbstractEntity abstractEntity;

    private static final Object[] getRightValues() {
        return new Object[]{
                new Object[]{"Nick", 45},
                new Object[]{"Joe", 55},
                new Object[]{"Company", 65}
        };
    }

    private static final Object[] getWrongId() {
        return new Object[]{0, 0, null};
    }

    private static final Object[] getWrongName() {
        return new Object[]{"", null, ""};
    }


    @Before
    public void setUp() {
        abstractEntity = new AbstractEntity(VALID_ID, VALID_NAME);
    }

    @Test
    @Parameters(method = "getRightValues")
    public void constructorShouldSetIdAndName(String name, long id) {
        AbstractEntity entity = new AbstractEntity(id, name);
        assertNotNull("Entity wasn't create in right way", entity);
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getWrongId")
    public void setWrongId(long id) {
        abstractEntity.setId(id);
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getWrongName")
    public void setWtongName(String name) {
        abstractEntity.setName(name);
    }

}