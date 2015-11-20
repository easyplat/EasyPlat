package com.langeye.entity;

import com.langeye.general.GeneralEntity;

import javax.persistence.*;

/**
 * Author:  Fish
 * Date:    2015/11/19.
 * Project: EasyPlat
 */

@Entity
@Table(name = "PM_TaskSchedule")
public class TaskSchedule extends GeneralEntity{
    private String content;
    private Task task;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "taskId")
    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
