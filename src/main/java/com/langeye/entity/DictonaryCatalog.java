package com.langeye.entity;

import com.langeye.general.GeneralEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Author:  Fish
 * Date:    2015/11/10.
 * Project: EasyPlat
 */
@Entity
@Table(name = "UC_DictonaryCatalog")
public class DictonaryCatalog extends GeneralEntity {
    private String title;
    private Set<Dictonary> dictonaries = new LinkedHashSet<Dictonary>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @OneToMany
    @JoinColumn(name="catalogId")
    public Set<Dictonary> getDictonaries() {
        return dictonaries;
    }

    public void setDictonaries(Set<Dictonary> dictonaries) {
        this.dictonaries = dictonaries;
    }
}
