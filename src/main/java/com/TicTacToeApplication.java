package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by brallan on 26/06/16.
 */
//@RestController
@SpringBootApplication
public class TicTacToeApplication {

//    @RequestMapping("/showMessage.html")
//    public String index(){
//        return "WEB-INF/static/board.html";
//    }

    public static void main(String[] args) {
        SpringApplication.run(TicTacToeApplication.class, args);
    }
}
