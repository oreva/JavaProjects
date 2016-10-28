package com.oreva.tasklist.menu;

/**
 * Created by Olga on 10/28/2016.
 */
public class RepetitiveMenuOption extends MenuOption {

    public RepetitiveMenuOption(int keyOption, String label, Runnable function) {
        super(keyOption, label, function);
    }

    public RepetitiveMenuOption(int keyOption, String label, Menu submenu, Runnable function) {
        super(keyOption, label, submenu, function);
    }

    @Override
    public void select() {
        Runnable menuCall = hasSubmenu() ? getSubmenu()::show : getParentMenu()::show;
        if (null != getFunction()) {
            getFunction().run();
        }
        menuCall.run();
    }
}
