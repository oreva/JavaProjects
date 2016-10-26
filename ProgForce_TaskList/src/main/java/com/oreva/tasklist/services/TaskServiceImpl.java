package com.oreva.tasklist.services;

import com.oreva.tasklist.dao.TaskDAO;
import com.oreva.tasklist.entities.Task;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Olga on 10/26/2016.
 */
public class TaskServiceImpl extends EntityServiceImpl<Task> {

    private static final TaskDAO dao = new TaskDAO();
    private static final TaskServiceImpl instance = new TaskServiceImpl();

    private TaskServiceImpl() {}

    public static TaskServiceImpl getDefaultService() {
        return instance;
    }

    @Override
    public void create(Task entity) {
        try {
            dao.create(entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Task> findAll() {
        List<Task> result = null;
        try {
            result = dao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
