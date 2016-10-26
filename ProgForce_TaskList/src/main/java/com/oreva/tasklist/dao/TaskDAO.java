package com.oreva.tasklist.dao;

import com.oreva.tasklist.entities.Task;
import com.oreva.tasklist.jdbc.DBManager;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.Date;

/**
 * Created by Olga on 10/26/2016.
 */
public class TaskDAO implements EntityDAO<Task> {

    @Override
    public void create(Task entity) throws SQLException {
        if (null == entity) {
            return;
        }
        Connection connection = null;
        try {
            connection = DBManager.instance().getConnection();

            String sql = "insert into task (name, priority, date_due) values (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, entity.getName());
            statement.setObject(2, entity.getPriority());
            statement.setObject(3, entity.getDateDue());

            statement.execute();

        } finally {
            connection.close();
        }
    }

    @Override
    public List<Task> findAll() throws SQLException {
        Connection connection = null;
        try {
            connection = DBManager.instance().getConnection();

            Statement statement = connection.createStatement();
            String sql = "select id, name, priority, date_due from task order by id";
            ResultSet resultSet = statement.executeQuery(sql);

            Task task = null;
            List<Task> resultList = new ArrayList<>();
            while (resultSet.next()) {
                task = new Task(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        (Date) resultSet.getObject(4)
                );
                resultList.add(task);
            }
            return resultList;

        } finally {
            connection.close();
        }
    }
}
