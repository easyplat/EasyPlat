package com.langeye.dao.impl;

import com.langeye.dao.SysUserDao;
import com.langeye.entity.SysUser;
import com.langeye.general.GeneralDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * Author:  Fish
 * Date:    2015/11/10.
 * Project: EasyPlat
 */
@Repository("sysUserDao")
public class SysUserDaoImpl extends GeneralDaoImpl<SysUser> implements SysUserDao {

    public SysUser get(SysUser user) {
        String hql=" from SysUser Where name=? and password=? ";
        user= get(hql, new Object[]{user.getName(), user.getPassword()});

        return user;
    }
}
