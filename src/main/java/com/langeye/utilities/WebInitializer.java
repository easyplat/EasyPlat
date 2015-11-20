package com.langeye.utilities;

import org.apache.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Author:  Fish
 * Date:    2015/11/12.
 * Project: EasyPlat
 */
public class WebInitializer implements WebApplicationInitializer {
    private static Logger logger = Logger.getLogger(WebInitializer.class);

    public void onStartup(ServletContext servletContext) throws ServletException {
        logger.info("Web≥ı ºªØ");
    }
}
