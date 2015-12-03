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
    private String subTitle;
    private String subject;
    private String body;
    private int isPublish;
    private int isStatic;
    private String author;
    private String origin;
    private String cssClass;
    private String seoTitle;
    private String seoKeyWords;
    private String seoDescription;
    private int orderBy;
    private int visitCount;

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

    public int getIsStatic() {
        return isStatic;
    }

    public void setIsStatic(int isStatic) {
        this.isStatic = isStatic;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getSeoTitle() {
        return seoTitle;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }

    public String getSeoKeyWords() {
        return seoKeyWords;
    }

    public void setSeoKeyWords(String seoKeyWords) {
        this.seoKeyWords = seoKeyWords;
    }

    public String getSeoDescription() {
        return seoDescription;
    }

    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription;
    }

    public int getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(int orderBy) {
        this.orderBy = orderBy;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }
}
