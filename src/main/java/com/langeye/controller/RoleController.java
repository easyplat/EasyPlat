package com.langeye.controller;

import com.langeye.common.Pager;
import com.langeye.entity.Role;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Fish on 2015/11/6.
 */
@Controller()
@RequestMapping(value="role")
@SessionAttributes("SESSION_USER")
public class RoleController extends BaseController{
    protected final Log logger = LogFactory.getLog(getClass());

    @InitBinder
    protected void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "/list/{page}/{pageSize}")
    /*@ResponseBody*/
    public String list(@PathVariable("page") int page,
                        @PathVariable("pageSize") int pageSize,
                        Model model,
                        @RequestParam(name = "resultMsg",defaultValue = "",required = false) String resultMsg){
        Pager<Role> pager =roleService.paging(null, page, pageSize);
        model.addAttribute("pager",pager);
        model.addAttribute("resultMsg",resultMsg);
        return "role/list";
    }

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String createGet(Model model){
        model.addAttribute("action","/role/create");
        model.addAttribute("entity",new Role());
        return "role/edit";
    }

    @RequestMapping(value="/create",method = RequestMethod.POST)
    public String createPost(@Valid @ModelAttribute("role") Role role,
            BindingResult result,
            Model model,
            RedirectAttributesModelMap modelMap){
        if(result.hasErrors()){

            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError error : errors){
                model.addAttribute(error.getObjectName(),error.getDefaultMessage());
            }
        }
        else{
            role.setDateCreated(new Date());
            //role.setDataCreated();
            roleService.save(role);
        }
        modelMap.addAttribute("resultMsg","资料新增成功");
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
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError error : errors){
                model.addAttribute(error.getObjectName(),error.getDefaultMessage());
            }
        }
        else{
            role.setDateModified(new Date());
            roleService.update(role);
        }
        modelMap.addAttribute("resultMsg","资料修改成功!");
        return "redirect:list/1/20";
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String deletePost(@PathVariable("id") int id,RedirectAttributesModelMap modelMap){
        Role role = new Role();
        role.setId(id);
        roleService.delete(role);
        modelMap.addAttribute("resultMsg","资料删除成功");
        return "redirect:list/1/20";
    }
}
