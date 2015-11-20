package com.langeye.general;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Fish on 2015/11/6.
 */
@MappedSuperclass
public class GeneralEntity implements Serializable{

    private int id;
    private Date dateCreated;
    private int dataCreated;
    private Date dateModified;
    private int dataModified;

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getDataCreated() {
        return dataCreated;
    }

    public void setDataCreated(int dataCreated) {
        this.dataCreated = dataCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public int getDataModified() {
        return dataModified;
    }

    public void setDataModified(int dataModified) {
        this.dataModified = dataModified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeneralEntity that = (GeneralEntity) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
