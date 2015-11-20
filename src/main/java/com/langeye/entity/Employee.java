package com.langeye.entity;

import com.langeye.general.GeneralEntity;

import java.util.Set;

/**
 * Author:  Fish
 * Date:    2015/11/19.
 * Project: EasyPlat
 */
public class Employee extends GeneralEntity {
    private String empNo;
    private Set<Task> tasks;
}
