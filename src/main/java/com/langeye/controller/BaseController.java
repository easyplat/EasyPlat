package com.langeye.controller;

import com.langeye.entity.SysUser;
import com.langeye.general.GeneralController;
import com.langeye.service.ArticleService;
import com.langeye.service.RoleService;
import com.langeye.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Author:  Fish
 * Date:    2015/11/12.
 * Project: EasyPlat
 */
public class BaseController extends GeneralController {

    @Autowired(required = true)
    @Qualifier("userService")
    protected SysUserService userService;

    @Autowired(required = true)
    @Qualifier("roleService")
    protected RoleService roleService;

    @Autowired(required = true)
    @Qualifier("articleService")
    protected ArticleService articleService;
}
