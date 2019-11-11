package maze.menu;

import java.util.*;

public class Menu {

    private Map<String, MenuItem> menuItems;

    public Menu() {
        this.menuItems = new LinkedHashMap<>();
    }

    public void addMenuItem(String identifier, MenuItem menuItem) {
        menuItems.put(identifier, menuItem);
    }

    public void executeMenuItem(String identifier) {
        menuItems.get(identifier).execute();
    }

    public boolean hasMenuItem(String identifier) {
        return menuItems.containsKey(identifier);
    }

    public void printMenu() {
        System.out.println("=== Menu ===");
        for(String key : menuItems.keySet()) {
            System.out.println( key + ". " + menuItems.get(key) );
        }
    }

}
