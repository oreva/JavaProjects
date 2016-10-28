package com.oreva.tasklist.dao;

import com.oreva.tasklist.entities.ArchivedTask;
import com.oreva.tasklist.entities.Task;
import com.oreva.tasklist.jdbc.DBManager;
import javafx.scene.shape.Arc;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Olga on 10/28/2016.
 */
public class ArchivedTaskDAO implements EntityDAO<ArchivedTask> {
    @Override
    public void create(ArchivedTask entity) throws SQLException {
        if (null == entity) {
            return;
        }
        Connection connection = null;
        try {
            entity.setDateArchived(new Date());

            connection = DBManager.instance().getConnection();

            String sql = "insert into archived_task (task_id, name, priority, date_due, date_archived) " +
                    "values (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setLong(1, entity.getTaskId());
            statement.setString(2, entity.getName());
            statement.setObject(3, entity.getPriority());
            statement.setObject(4, entity.getDateDue());
            statement.setObject(5, entity.getDateArchived());

            statement.execute();

        } finally {
            connection.close();
        }
    }

    @Override
    public List<ArchivedTask> findAll() throws SQLException {
        Connection connection = null;
        try {
            connection = DBManager.instance().getConnection();

            Statement statement = connection.createStatement();
            String sql = "select id, task_id, name, priority, date_due, date_archived from archived_task order by id";
            ResultSet resultSet = statement.executeQuery(sql);

            ArchivedTask task = null;
            List<ArchivedTask> resultList = new ArrayList<>();
            while (resultSet.next()) {
                task = new ArchivedTask(
                        resultSet.getLong(1),
                        resultSet.getLong(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        (Date) resultSet.getObject(5),
                        (Date) resultSet.getObject(6)
                );
                resultList.add(task);
            }
            return resultList;

        } finally {
            connection.close();
        }
    }
}
