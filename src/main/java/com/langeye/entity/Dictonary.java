package com.langeye.entity;

import com.langeye.general.GeneralEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Author:  Fish
 * Date:    2015/11/10.
 * Project: EasyPlat
 */
@Entity
@Table(name="UC_Dictonary")
public class Dictonary extends GeneralEntity {
    private String title;
    private int state;
    private DictonaryCatalog catalog;
    private String code;
    private String value;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @ManyToOne
    @JoinColumn(name = "catalogId")
    public DictonaryCatalog getCatalog() {
        return catalog;
    }

    public void setCatalog(DictonaryCatalog catalog) {
        this.catalog = catalog;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
