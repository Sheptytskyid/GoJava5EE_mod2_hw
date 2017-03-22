package jdbchomework.console;

public class MenuLauncher {

    private MainMenu mainMenu;
    private MenuContents menuContents;

    public MenuLauncher(MainMenu mainMenu, MenuContents menuContents) {
        this.mainMenu = mainMenu;
        this.menuContents = menuContents;
    }

    public void consoleMain() {
        menuContents.makeMenus();
        mainMenu.menu();
    }
}