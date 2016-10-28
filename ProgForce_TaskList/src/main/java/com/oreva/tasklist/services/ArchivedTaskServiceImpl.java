package com.oreva.tasklist.services;

import com.oreva.tasklist.dao.ArchivedTaskDAO;
import com.oreva.tasklist.entities.ArchivedTask;
import com.oreva.tasklist.entities.Task;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Olga on 10/28/2016.
 */
public class ArchivedTaskServiceImpl extends EntityServiceImpl<ArchivedTask> {
    private static final ArchivedTaskDAO dao = new ArchivedTaskDAO();
    private static final ArchivedTaskServiceImpl instance = new ArchivedTaskServiceImpl();

    private ArchivedTaskServiceImpl() {}

    public static ArchivedTaskServiceImpl getDefaultService() {
        return instance;
    }

    @Override
    public void create(ArchivedTask entity) {
        try {
            dao.create(entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ArchivedTask> findAll() {
        List<ArchivedTask> result = null;
        try {
            result = dao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void archiveTask(Task task) {
        if (null != task) {
            ArchivedTask archivedTask = new ArchivedTask(task);
            create(archivedTask);
        }
    }
}
