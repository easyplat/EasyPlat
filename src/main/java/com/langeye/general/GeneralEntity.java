package com.langeye.general;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
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
    private Date dateModified = new Date();
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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable=false)
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Column(updatable=false)
    public int getDataCreated() {
        return dataCreated;
    }

    public void setDataCreated(int dataCreated) {
        this.dataCreated = dataCreated;
    }

    @Temporal(TemporalType.TIMESTAMP)
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
