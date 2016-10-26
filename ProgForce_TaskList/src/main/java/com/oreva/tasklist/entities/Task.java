package com.oreva.tasklist.entities;

import java.util.Date;

/**
 * Created by Olga on 10/26/2016.
 */
public class Task extends Entity {
    private Long id;
    private String name;
    private Integer priority;
    private Date dateDue;

    public Task() {
    }

    public Task(Long id, String name, Integer priority, Date dateDue) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dateDue = dateDue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
