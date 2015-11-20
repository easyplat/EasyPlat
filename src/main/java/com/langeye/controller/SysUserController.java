package com.langeye.controller;

import com.langeye.entity.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Author:  Fish
 * Date:    2015/11/9.
 * Project: EasyPlat
 */
@Controller
@RequestMapping("/user")
public class SysUserController extends BaseController {
    @RequestMapping(value = "/list")
    public String list(){
        return "list";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@ModelAttribute("User")SysUser user){
        return "";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(@ModelAttribute("User")SysUser user){
        return "";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete(@RequestParam("id")String id){
        return "";
    }

    @RequestMapping(value = "/profile",method = {RequestMethod.GET,RequestMethod.POST})
    public String profile(Model model){
        model.addAttribute("user","");
        return "profile";
    }
}
