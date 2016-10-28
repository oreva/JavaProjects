package com.oreva.tasklist.controllers;

import com.oreva.tasklist.entities.ArchivedTask;
import com.oreva.tasklist.entities.Task;
import com.oreva.tasklist.services.ArchivedTaskServiceImpl;
import com.oreva.tasklist.services.TaskServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Olga on 10/27/2016.
 */
public class TaskController {
    private static final TaskServiceImpl service = TaskServiceImpl.getDefaultService();
    private static final ArchivedTaskServiceImpl archivedTasksService = ArchivedTaskServiceImpl.getDefaultService();

    private static final TaskController instance = new TaskController();

    private TaskController() {}
    public static TaskController getDefaultController() {
        return instance;
    }

    public void createTask() {
        Task task = new Task();

        System.out.println("Please, enter task's name:");
        Scanner scanner = new Scanner(System.in);
        task.setName(scanner.nextLine());

        Date date = null;
        while (null == date) {
            try {
                System.out.println("Please, enter task's due date (use format 'MM-dd-yyyy'):");
                SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
                date = formatter.parse(scanner.nextLine());
                task.setDateDue(date);
            } catch (ParseException e) {
                date = null;
            }
        }

        int priority = -1;
        while (priority < 0) {
            try {
                System.out.println("Please, enter task's priority:");
                priority = Integer.parseInt(scanner.nextLine());
                task.setPriority(priority);
            } catch (NumberFormatException e) {
                priority = -1;
            }
        }

        //Call service to create task
        service.create(task);

        System.out.println(String.format("Task %s created.", task.getName()));
    }

    public void listAllActiveTasks() {
        List<Task> tasks = service.findAll();
        if (tasks.isEmpty()) {
            System.out.println("There are no tasks in DB");
        } else {
            System.out.println(String.format("There are %d tasks found:", tasks.size()));
            System.out.println("Task ID\tTask Name\tPriority\tDue Date\tis Overdue");
        }
        Iterator<Task> iterator = tasks.iterator();
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        while (iterator.hasNext()) {
            Task task = iterator.next();
            System.out.println(String.format("%s\t%s\t%s\t%s\t%s\t",
                    task.getId(),
                    task.getName(),
                    task.getPriority(),
                    formatter.format(task.getDateDue()),
                    task.isOverdue() ? "yes" : ""
            ));
        }
    }

    public void listAllFinishedTasks() {
        List<ArchivedTask> tasks = archivedTasksService.findAll();
        if (tasks.isEmpty()) {
            System.out.println("\nThere are no finished tasks in DB");
        } else {
            System.out.println(String.format("\nThere are %d finished tasks found:", tasks.size()));
            System.out.println("Task ID\tTask Name\tPriority\tDue Date\tDate Completed");
        }
        Iterator<ArchivedTask> iterator = tasks.iterator();
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        while (iterator.hasNext()) {
            ArchivedTask task = iterator.next();
            System.out.println(String.format("%s\t%s\t%s\t%s\t%s\t",
                    task.getTaskId(),
                    task.getName(),
                    task.getPriority(),
                    formatter.format(task.getDateDue()),
                    formatter.format(task.getDateArchived())
            ));
        }
    }

    public void completeTask() {
        long taskId = -1;
        while (taskId < 0) {
            try {
                System.out.println("Please, specify the ID of the task you want to complete:");
                Scanner scanner = new Scanner(System.in);
                taskId = Long.parseLong(scanner.nextLine());
            } catch (Exception e) {
                taskId = -1;
            }
        }

        //Complete the task
        boolean result = service.completeTask(taskId);
        if (!result) {
            System.out.println(String.format(
                    "The ID you entered is wrong. There are no tasks with ID = %d in the DB.", taskId)
            );
        } else {
            System.out.println("Done.");
        }
    }
}
