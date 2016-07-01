package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by brallan on 25/06/16.
 */
@Controller
public class TicTacToeController {

    @RequestMapping("/")
    public String hello() {
        return  "Hello World1";
    }

}
