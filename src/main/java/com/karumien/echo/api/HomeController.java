/*
 * Copyright (c) 2019-2029 Karumien s.r.o.
 *
 * Karumien s.r.o. is not responsible for defects arising from 
 * unauthorized changes to the source code.
 */
package com.karumien.echo.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Echo Service Response Controller.
 *
 * @author <a href="miroslav.svoboda@karumien.com">Miroslav Svoboda</a>
 * @since 1.0, 15. 6. 2019 21:27:49
 */
@Controller
public class HomeController {
    
    @Value("${spring.application.response:BASE}")
    private String identification;
    
    @RequestMapping(method = RequestMethod.GET, value = "/", produces="text/html")    
    @ResponseBody
    public String getVersion() {
        return "ECHO HTTP [" + identification + "] OK";
    }
    
}
