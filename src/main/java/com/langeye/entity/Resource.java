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
@Table(name = "UC_Resource")
public class Resource extends GeneralEntity {
    private String title;
    private String description;
    private String resourceType;
    private int state;
    private String icon;
    private String cssClass;
    private String action;
    private String target;
    private Resource parent;
    private Set<Resource> resources = new HashSet<Resource>();
    private Set<Role> roles = new HashSet<Role>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @ManyToOne()
    public Resource getParent() {
        return parent;
    }

    public void setParent(Resource parent) {
        this.parent = parent;
    }

    @OneToMany(mappedBy ="parent")
    public Set<Resource> getResources() {
        return resources;
    }

    public void setResources(Set<Resource> resources) {
        this.resources = resources;
    }

    @ManyToMany(mappedBy = "resources",cascade = CascadeType.ALL)
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
