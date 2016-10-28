package com.oreva.tasklist.entities;

import java.util.Date;

/**
 * Created by Olga on 10/28/2016.
 */
public class ArchivedTask extends Entity {
    private Long id;
    private Long taskId;
    private String name;
    private Integer priority;
    private Date dateDue;
    private Date dateArchived;

    public ArchivedTask() {}

    public ArchivedTask(Task source) {
        setTaskId(source.getId());
        setName(source.getName());
        setPriority(source.getPriority());
        setDateDue(source.getDateDue());
    }

    public ArchivedTask(Long id, Long taskId, String name, Integer priority, Date dateDue, Date dateArchived) {
        this.id = id;
        this.taskId = taskId;
        this.name = name;
        this.priority = priority;
        this.dateDue = dateDue;
        this.dateArchived = dateArchived;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getDateDue() {
        return dateDue;
    }

    public void setDateDue(Date dateDue) {
        this.dateDue = dateDue;
    }

    public Date getDateArchived() {
        return dateArchived;
    }

    public void setDateArchived(Date dateArchived) {
        this.dateArchived = dateArchived;
    }
}
