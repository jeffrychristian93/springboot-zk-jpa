package com.jeffrychristian.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jeffry.christian on 11/8/2016.
 */
@Controller
public class BaseController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/app")
    public String success() {
        return "workspace";
    }

}