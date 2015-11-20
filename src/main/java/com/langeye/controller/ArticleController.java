package com.langeye.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author:  Fish
 * Date:    2015/11/20.
 * Project: EasyPlat
 */
@Controller
@RequestMapping("/article")
public class ArticleController extends BaseController{

    @RequestMapping(value = "/list/{page}/{pageSize}")
    public String list(HttpServletRequest request,HttpServletResponse response,Model model){

        return "article/list";
    }

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String createGet(){
        return "article/edit";
    }
}
