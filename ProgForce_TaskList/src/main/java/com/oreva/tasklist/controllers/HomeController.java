package com.oreva.tasklist.controllers;

import com.oreva.tasklist.menu.Menu;
import com.oreva.tasklist.menu.MenuOption;
import com.oreva.tasklist.menu.RepetitiveMenuOption;
import com.oreva.tasklist.menu.SimpleMenuOption;

/**
 * Created by Olga on 10/27/2016.
 */
public class HomeController {
    private static final HomeController instance = new HomeController();

    private HomeController() {}
    public static HomeController getDefaultController() {
        return instance;
    }
    public static final TaskController taskController = TaskController.getDefaultController();

    public static final Menu menu;
    public static final Menu taskMenu;
    static {
        taskMenu = new Menu(
                new RepetitiveMenuOption(1, "Mark Task as Completed", taskController::completeTask),
                new RepetitiveMenuOption(2, "List All Finished Tasks", taskController::listAllFinishedTasks),
                new SimpleMenuOption(3, "Go Back To The Main Menu", getDefaultController()::showMainMenu)
        );
        menu = new Menu(
            new RepetitiveMenuOption(1, "Add Task", taskController::createTask),
            new RepetitiveMenuOption(2, "List All Tasks", taskMenu, taskController::listAllActiveTasks),
            new SimpleMenuOption(3, "Exit", getDefaultController()::exit)
        );
    }

    public void showMainMenu() {
        menu.show();
    }

    public void exit() {
        System.out.print("Exitting...");
        System.exit(0);
    }
}

