package com.langeye.controller;

import com.langeye.common.ActionResult;
import com.langeye.common.Pager;
import com.langeye.entity.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Fish on 2015/11/6.
 */
@Controller()
@RequestMapping(value="role")
@SessionAttributes("SESSION_USER")
public class RoleController extends BaseController{

    protected void initBinder(WebDataBinder binder){

    }

    @RequestMapping(value = "/list/{page}/{pageSize}")
    /*@ResponseBody*/
    public String list(@PathVariable("page") int page,
                        @PathVariable("pageSize") int pageSize,
                        Model model,
                        RedirectAttributesModelMap modelMap){
        Pager<Role> pager =roleService.paging(null, page, pageSize);
        model.addAttribute("pager",pager);
        model.addAttribute("resultMsg",modelMap.get("resultMsg"));
        return "role/list";
    }

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String createGet(Model model){
        model.addAttribute("action","/role/create");
        return "role/edit";
    }

    @RequestMapping(value="/create",method = RequestMethod.POST)
    public String createPost(@Valid @ModelAttribute("role") Role role,
            BindingResult result,
            Model model,
            RedirectAttributesModelMap modelMap){
        if(result.hasErrors()){
            //如果有异常发生,将异常信息打印到前台
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError error : errors){
                model.addAttribute(error.getObjectName(),error.getDefaultMessage());
            }
        }
        else{
            //设定为当前时间新建
            role.setDateCreated(Calendar.getInstance().getTime());
            //role.setDataCreated();
            roleService.save(role);
        }
        modelMap.addAttribute("resultMsg","新增成功!");
        return "redirect:list/1/20";
    }

    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String editGet(@PathVariable("id") int id,Model model){
        Role entity = roleService.get(id);
        model.addAttribute("entity",entity);
        model.addAttribute("action","/role/edit");
        return "role/edit";
    }

    @RequestMapping(value="/edit",method = RequestMethod.POST)
    public String editPost(@Valid @ModelAttribute("role") Role role,
                             BindingResult result,
                             Model model,
                             RedirectAttributesModelMap modelMap){
        if(result.hasErrors()){
            //如果有异常发生,将异常信息打印到前台
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError error : errors){
                model.addAttribute(error.getObjectName(),error.getDefaultMessage());
            }
        }
        else{
            //设定为当前时间新建
            role.setDateModified(Calendar.getInstance().getTime());
            roleService.update(role);
        }
        modelMap.addAttribute("resultMsg","修改成功!");
        return "redirect:list/1/20";
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String deletePost(@PathVariable("id") int id,
                             Model model,
                             RedirectAttributesModelMap modelMap){
        Role role = new Role();
        role.setId(id);
        roleService.delete(role);
        modelMap.addAttribute("resultMsg","修改成功!");
        return "redirect:list/1/20";
    }
}
