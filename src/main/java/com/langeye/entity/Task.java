package com.langeye.entity;

import com.langeye.general.GeneralEntity;

import javax.persistence.*;
import java.util.Set;

/**
 * Author:  Fish
 * Date:    2015/11/19.
 * Project: EasyPlat
 */
@Entity
@Table(name = "PM_Task")
public class Task extends GeneralEntity {
    /**
     * �������
     */
    private String title;
    /**
     * ��������
     */
    private String content;
    /**
     * ������
     */
    private Employee employee;

    /**
     * ��������
     */
    private Set<TaskSchedule> schedules;

    /**
     * ����״̬
     * 0: ������
     * 1: ������
     * 2: ���
     * 3: ���½���
     * 4: ����
     */
    private int state;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "taskId")
    public Set<TaskSchedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<TaskSchedule> schedules) {
        this.schedules = schedules;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
