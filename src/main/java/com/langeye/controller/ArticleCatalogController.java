package com.langeye.controller;

import com.langeye.service.ArticleCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@RequestMapping("/articleCatalog")
public class ArticleCatalogController extends BaseController{

    @Autowired(required = true)
    @Qualifier(value = "articleCatalogService")
    private ArticleCatalogService articleCatalogService;


    @RequestMapping(value = "/list/{page}/{pageSize}")
    public String list(HttpServletRequest request,HttpServletResponse response,Model model){

        return "articlecatalog/list";
    }

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String createGet(){
        return "articlecatalog/edit";
    }
}
