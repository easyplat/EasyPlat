package com.langeye.service;

import com.langeye.dao.SysUserDao;
import com.langeye.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Author:  Fish
 * Date:    2015/11/10.
 * Project: EasyPlat
 */
@Service("userService")
public class SysUserServiceImpl implements SysUserService {
    @Autowired(required = true)
    @Qualifier("sysUserDao")
    private SysUserDao dao;

    public boolean isValid(SysUser user) {
        return null != dao.get(user);
    }

    public SysUser get(SysUser user) {
        return dao.get(user);
    }
}
