package com.langeye.general;

import com.langeye.entity.SysUser;
import com.langeye.service.RoleService;
import com.langeye.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Author:  Fish
 * Date:    2015/11/10.
 * Project: EasyPlat
 */
public class GeneralController implements org.springframework.web.context.ServletContextAware{
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    public void setServletContext(ServletContext servletContext) {

    }
}
