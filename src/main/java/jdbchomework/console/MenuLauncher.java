package jdbchomework.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuLauncher {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private MainMenu mainMenu;
    private MenuContents menuContents;

    public MenuLauncher(MainMenu mainMenu, MenuContents menuContents) {
        this.mainMenu = mainMenu;
        this.menuContents = menuContents;
    }

    public void consoleMain() {
        menuContents.makeMenus();
        mainMenu.menu();
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedReader getReader() {
        return reader;
    }
}