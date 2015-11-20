package com.langeye.entity;


import com.langeye.general.GeneralEntity;

import javax.persistence.*;

/**
 * Author:  Fish
 * Date:    2015/11/10.
 * Project: EasyPlat
 */
@Entity
@Table(name = "CMS_Attachement")
public class Attachement extends GeneralEntity {
    private String fileName;
    private String originalName;
    private long fileSize;
    private String fileExt;
    private int fileType;
    private Article article;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }

    public int getFileType() {
        return fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    @ManyToOne
    @JoinColumn(name = "articleId")
    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
