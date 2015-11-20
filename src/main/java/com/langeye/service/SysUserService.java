package com.langeye.service;

import com.langeye.entity.SysUser;

/**
 * Author:  Fish
 * Date:    2015/11/10.
 * Project: EasyPlat
 */
public interface SysUserService  {
    public boolean isValid(SysUser user);
    public SysUser get(SysUser user);
}
