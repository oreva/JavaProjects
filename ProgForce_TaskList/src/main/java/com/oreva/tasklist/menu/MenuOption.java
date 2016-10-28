package com.oreva.tasklist.menu;

/**
 * Created by Olga on 10/27/2016.
 */
public abstract class MenuOption {
    private int keyOption;
    private Runnable function;
    private String label;
    private Menu submenu;
    private Menu parentMenu;

    public MenuOption(int keyOption, String label, Runnable function) {
        this.keyOption = keyOption;
        this.function = function;
        this.label = label;
    }

    public MenuOption(int keyOption, String label, Menu submenu, Runnable function) {
        this(keyOption, label, function);
        setSubmenu(submenu);
    }

    public int getKeyOption() {
        return keyOption;
    }

    public void setKeyOption(int keyOption) {
        this.keyOption = keyOption;
    }

    public Runnable getFunction() {
        return function;
    }

    public void setFunction(Runnable function) {
        this.function = function;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Menu getSubmenu() {
        return submenu;
    }

    public void setSubmenu(Menu submenu) {
        this.submenu = submenu;
    }

    public boolean hasSubmenu() {
        return submenu != null;
    }

    public Menu getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(Menu parentMenu) {
        this.parentMenu = parentMenu;
    }

    /**
     * Calls the action we need to do when user selects this menu option
     */
    public abstract void select();
}
