package com.oreva.tasklist;

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
        System.out.println( "Hello World!" );

        TaskServiceImpl taskService = TaskServiceImpl.getDefaultService();

        /*for (int i = 0; i < 10; i++) {
            Task t = new Task();
            t.setName("Task " + i);
            t.setPriority(i);
            t.setDateDue(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));

            taskService.create(t);
        }*/

        List<Task> list = taskService.findAll();

        System.out.println(list);
    }
}
