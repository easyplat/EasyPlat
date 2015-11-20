package com.langeye.controller;

import com.langeye.common.Pager;
import com.langeye.entity.Article;
import com.langeye.entity.ArticleCatalog;
import com.langeye.entity.SysUser;
import com.langeye.entity.Task;
import com.langeye.formbrean.User;
import com.langeye.general.GeneralController;
import com.langeye.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * Created by Fish on 2015/11/6.
 */
@Controller
@RequestMapping(value="admin")
public class AdminController extends BaseController {

    @Autowired(required = true)
    @Qualifier("taskService")
    private TaskService taskService;


    /**
     * ��ʾ��¼����
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginGet(){
        return "login";
    }


    /**
     * ��¼��֤
     * @param user      ��¼������
     * @param request   request����
     * @param response  response����
     * @param modelMap  ���ݲ�������ҳ��(User)
     * @return
     */
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String loginPost(@ModelAttribute("User")User user,
                            HttpServletRequest request,
                            HttpServletResponse response,
                            /**
                                 * RedirectAttributesModelMap �����ض��򴫵ݲ���
                                 * ���ض�������ModelMap�Լ�request attribute���ᴫ�ݲ���
                                 * �ò����������ڲ�ͬҳ��֮����ת��ɾ���󴫵ݵ���ҳ��Ĳ���
                             */
                            RedirectAttributesModelMap modelMap,
                            Model model) throws UnsupportedEncodingException {

        HttpSession session = request.getSession();
        SysUser entity = new SysUser();
        entity.setName(user.getUserName());
        entity.setPassword(user.getUserPswd());
        entity.setAuthCode(user.getAuthCode());
        modelMap.addFlashAttribute("User", entity);
        if(userService.isValid(entity)){
            entity = userService.get(entity);
            session.setAttribute("SESSION_USER", entity);
            request.setAttribute("User",entity);
            return "redirect:main";
        }
        model.addAttribute("errorMsg","�˺Ż��������,��˶Ժ���������");
        return "login";
    }

    @RequestMapping(value = "/main")
    public String main(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap) {
        return "main";
    }

    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap) {
        return "index";
    }

    @RequestMapping(value="/top")
    public String top(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap){
        return "top";
    }

    @RequestMapping(value="/left")
    public String left(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap){
        return "left";
    }

    @RequestMapping(value="/footer")
    public String footer(HttpServletRequest request,HttpServletResponse response, ModelMap modelMap){
        modelMap.addAttribute("Version","Build20151119");
        return "footer";
    }

    @RequestMapping(value="/dashbord")
    public String dashbord(HttpServletRequest request,HttpServletResponse response, Model model){
        ArticleCatalog catalog = new ArticleCatalog();
        catalog.setId(1);
        Article article = new Article();
        article.setCatalog(catalog);
        Pager<Article> articlePager =articleService.paging(article, 1, 10);
        model.addAttribute("articles",articlePager);

        Task task = new Task();
        Pager<Task> taskPager = taskService.paging(task,1,10);
        model.addAttribute("tasks",taskPager);
        return "dashbord";
    }

    @RequestMapping(value = "/setting")
    public String setting(HttpServletRequest request,HttpServletResponse response,Model model){

        return "setting";
    }

    @RequestMapping(value = "/logout")
    public String logOut(){

        return "redirect:login";
    }
}
