package com.oreva.tasklist;

import com.oreva.tasklist.controllers.HomeController;
import com.oreva.tasklist.entities.Task;
import com.oreva.tasklist.jdbc.DBManager;
import com.oreva.tasklist.services.TaskServiceImpl;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
        HomeController controller = HomeController.getDefaultController();
        controller.showMainMenu();
    }
}
