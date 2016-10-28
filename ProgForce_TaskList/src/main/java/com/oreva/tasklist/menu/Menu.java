package com.oreva.tasklist.menu;

import java.util.*;

/**
 * Created by Olga on 10/27/2016.
 */
public class Menu {
    //We use LinkedHashMap because we want to store items in the insertion order, and access them by their keys
    private final Map<Integer, MenuOption> rootItems = new LinkedHashMap<>();
    private MenuOption parent = null;

    public Menu() {}

    public Menu(MenuOption... source) {
        addRootItems(source);
    }

    public Map<Integer, MenuOption> getRootItems() {
        return rootItems;
    }

    public MenuOption getParent() {
        return parent;
    }

    public void setParent(MenuOption parent) {
        this.parent = parent;
    }

    public void addRootItems(MenuOption... items) {
        for (int i = 0; i < items.length; i++) {
            addRootItem(items[i]);
        }
    }

    public void addRootItem(MenuOption item) {
        item.setParentMenu(this);
        rootItems.put(item.getKeyOption(), item);
    }

    public MenuOption getMenuOptionByValue(int optionValue) {
        return rootItems.get(optionValue);
    }

    public void show() {
        MenuOption operation = null;
        while (null == operation) {
            System.out.println("\nPlease, select one of the following actions:");
            Iterator<Integer> iterator = rootItems.keySet().iterator();
            while (iterator.hasNext()) {
                MenuOption op = rootItems.get(iterator.next());
                System.out.println(op.getKeyOption() + " - " + op.getLabel());
            }

            Scanner scanner = new Scanner(System.in);
            try {
                int action = Integer.parseInt(scanner.nextLine());
                operation = getMenuOptionByValue(action);
            } catch (Exception e) {
                //action = -1;
                operation = null;
            }
        }
        //Invoke method
        operation.select();
    }
}
