package jdbchomework.console;

public class ConsoleMain {

    private ContentsUserMenu contentsUserMenu;

    public ConsoleMain(ContentsUserMenu contentsUserMenu) {
        this.contentsUserMenu = contentsUserMenu;
    }

    public void consoleMain() {
        ListMenu.makeMenus();
        contentsUserMenu.mainMenu();
    }
}