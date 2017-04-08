package jdbchomework.console;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public abstract class AbstractMenu {

    public static final String CHOOSE_ACTION = "Choose action: ";
    public static final String ERROR_INCORRECT_MENU_ITEM_SELECTED = "ERROR: Incorrect menu item selected \n";
    public static final String SPLIT_LINE = "**************************************************************";
    protected MenuContents menuContents;
    private org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    public AbstractMenu(MenuContents menuContents) {
        this.menuContents = menuContents;
    }

    abstract void menu();

    public <E> void printListInConsole(List<String> header, List<E> options) {
        if (header != null) {
            header.forEach(System.out::println);
        }
        if (options != null) {
            for (int i = 0; i < options.size(); i++) {
                System.out.printf("%d %s %n", i + 1, options.get(i).toString());
            }
        }
    }

    protected int readInt(String message) {
        return Integer.parseInt(getValidInputFromUser(message, InputType.INTEGER));
    }

    protected String readString(String message) {
        return getValidInputFromUser(message, InputType.STRING);
    }

    protected String getValidInputFromUser(String message, InputType type) {
        System.out.println(message);
        String input = "";
        try {
            input = MenuLauncher.getReader().readLine();
            while (!type.getIsValid().test(input)) {
                System.out.println(type.getErrorMessage());
                input = MenuLauncher.getReader().readLine();
            }
        } catch (IOException e) {
            log.error("Error reading user input from console", e);
        }
        return input;
    }
}
