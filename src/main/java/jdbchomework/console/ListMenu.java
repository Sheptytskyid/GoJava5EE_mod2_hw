package jdbchomework.console;

import java.util.ArrayList;
import java.util.List;

public class ListMenu {

    private static List<String> siteHeader = new ArrayList<>();
    private static List<String> serviceHeader = new ArrayList<>();
    private static List<String> serviceMainMenu = new ArrayList<>();
    private static List<String> serviceCompaniesMenu = new ArrayList<>();
    private static List<String> selectionHeader = new ArrayList<>();
    private static List<String> selectionMenu = new ArrayList<>();

    private ListMenu() {
    }

    public static void makeMenus() {
        siteHeader.add("**************************************************************");
        siteHeader.add("\t\tWelcome to DB manager");
        siteHeader.add("**************************************************************");
        siteHeader.add(" ");

        serviceHeader.add("**************************************************************");
        serviceHeader.add("\n\tMain menu");
        serviceMainMenu.add("Go to companies");
        serviceMainMenu.add("Go to customers");
        serviceMainMenu.add("Go to developers");
        serviceMainMenu.add("Go to projects");
        serviceMainMenu.add("Go to skills");
        serviceMainMenu.add("Exit");

        selectionHeader.add("**************************************************************");
        selectionMenu.add("Yes");
        selectionMenu.add("No");
    }

    public static List<String> getSiteHeader() {
        return siteHeader;
    }

    public static List<String> getServiceHeader() {
        return serviceHeader;
    }

    public static List<String> getServiceMainMenu() {
        return serviceMainMenu;
    }

    public static List<String> getSelectionHeader() {
        return selectionHeader;
    }

    public static List<String> getSelectionMenu() {
        return selectionMenu;
    }
}