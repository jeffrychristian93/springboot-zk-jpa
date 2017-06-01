package com.jeffrychristian.app.controller.ui.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jeffry.christian on 12/13/2016.
 */

@Controller
public class JController {

    @RequestMapping("/tes")
    public void test(){
        System.out.println(new BCryptPasswordEncoder().encode("admin"));
    }

}
