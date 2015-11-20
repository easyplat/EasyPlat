package com.langeye.entity;

import com.langeye.general.GeneralEntity;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Fish on 2015/11/6.
 */
@Entity
@Table(name = "UC_Role")
public class Role extends GeneralEntity{
    private String name;
    private String description;
    private int state;
    private Set<SysUser> users = new HashSet<SysUser>();
    private Set<Resource> resources = new HashSet<Resource>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleId")
    public Set<SysUser> getUsers() {
        return users;
    }

    public void setUsers(Set<SysUser> users) {
        this.users = users;
    }

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "RoleResourceMapping",
            joinColumns ={@JoinColumn(name = "roleId", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "resourceId", referencedColumnName = "id")
            })
    public Set<Resource> getResources() {
        return resources;
    }

    public void setResources(Set<Resource> resources) {
        this.resources = resources;
    }
}
