package jdbchomework.console;

import java.util.ArrayList;
import java.util.List;

public class ListMenu {

    private static List<String> siteHeader = new ArrayList<>();
    private static List<String> serviceHeader = new ArrayList<>();
    private static List<String> serviceMenu = new ArrayList<>();
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
        serviceMenu.add("Get all companies");
        serviceMenu.add("Get all customers");
        serviceMenu.add("Get all developers");
        serviceMenu.add("Get all projects");
        serviceMenu.add("Get all skills");
        serviceMenu.add("Exit");

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

    public static List<String> getServiceMenu() {
        return serviceMenu;
    }

    public static List<String> getSelectionHeader() {
        return selectionHeader;
    }

    public static List<String> getSelectionMenu() {
        return selectionMenu;
    }
}