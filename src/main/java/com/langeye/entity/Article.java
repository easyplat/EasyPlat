package com.langeye.entity;

import com.langeye.general.GeneralEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Author:  Fish
 * Date:    2015/11/10.
 * Project: EasyPlat
 */
@Entity
@Table(name = "CMS_Article")
public class Article  extends GeneralEntity{
    private String title;
    private String subject;
    private String body;
    private int isPublish;

    private ArticleCatalog catalog;
    private Set<Attachement> attachements = new HashSet<Attachement>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(int isPublish) {
        this.isPublish = isPublish;
    }

    @ManyToOne
    @JoinColumn(name = "catalogId")
    public ArticleCatalog getCatalog() {
        return catalog;
    }

    public void setCatalog(ArticleCatalog catalog) {
        this.catalog = catalog;
    }

    @OneToMany
    @JoinColumn(name="articleId")
    public Set<Attachement> getAttachements() {
        return attachements;
    }

    public void setAttachements(Set<Attachement> attachements) {
        this.attachements = attachements;
    }
}
