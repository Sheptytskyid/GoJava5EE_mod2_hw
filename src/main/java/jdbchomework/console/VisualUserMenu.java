package jdbchomework.console;

import jdbchomework.MainWithJdbc;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;


public class VisualUserMenu {

    private org.slf4j.Logger log = LoggerFactory.getLogger(VisualUserMenu.class);

    public static void outputSplitLine() {
        System.out.println("**************************************************************");
    }

    public static <E> void printListInConsole(List<String> header, List<E> options) {
        if (header != null) {
            header.forEach(System.out::println);
        }
        if (options != null) {
            for (int i = 0; i < options.size(); i++) {
                System.out.printf("%d %s %n", i + 1, options.get(i).toString());
            }
        }
    }

    public String getValidInputFromUser(String message, InputType type) {
        System.out.println(message);
        String input = "";
        try {
            input = MainWithJdbc.getReader().readLine();
            while (!type.getIsValid().test(input)) {
                System.out.println(type.getErrorMessage());
                input = MainWithJdbc.getReader().readLine();
            }
        } catch (IOException e) {
            log.error(String.format("Error reading user input from console"), e);
        }
        return input;
    }
}
