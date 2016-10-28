package com.oreva.tasklist.menu;

/**
 * Created by Olga on 10/28/2016.
 */
public class SimpleMenuOption extends MenuOption {
    public SimpleMenuOption(int keyOption, String label, Runnable function) {
        super(keyOption, label, function);
    }

    public SimpleMenuOption(int keyOption, String label, Menu submenu, Runnable function) {
        super(keyOption, label, submenu, function);
    }

    @Override
    public void select() {
        if (null != getFunction()) {
            getFunction().run();
        }
    }
}
