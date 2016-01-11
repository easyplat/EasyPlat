package com.langeye.controller;

import com.baidu.ueditor.ActionEnter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Author:  Fish
 * Date:    2016/1/11.
 * Project: EasyPlat
 */
@Controller
@RequestMapping(value="editor")
public class UEditorController {

    @RequestMapping(value = "/getConfig",method = RequestMethod.GET)
    public void  getConfig(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("application/json");
        String rootPath = request.getSession().getServletContext().getRealPath("/");

        try {
            String exec = new ActionEnter(request, rootPath).exec();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
