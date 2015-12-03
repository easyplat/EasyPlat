package com.langeye.controller;

import com.langeye.entity.SysUser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Author:  Fish
 * Date:    2015/11/26.
 * Project: EasyPlat
 */
@RestController
public class BizController {
    @RequestMapping(value="/login/{name}", method= RequestMethod.GET,produces={"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public SysUser login(@PathVariable(value = "name") String name) {
        SysUser user = new SysUser();
        user.setName(name);
        user.setPassword("admin");
        return user;
    }
}
