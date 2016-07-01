package com.controller;

import com.model.TicTacToeModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by brallan on 25/06/16.
 */
@Controller
public class TicTacToeController {

    private TicTacToeModel ticTacToe;
    private boolean isWinner;

    public TicTacToeController() {
        ticTacToe = new TicTacToeModel();
    }

    @RequestMapping("/")
    public String index() {
        return "board.html";
    }

    @RequestMapping(value = "/play", method = RequestMethod.GET)
    @ResponseBody
    public String hi(@RequestParam("pos") String pPos) {
        int pos = Integer.parseInt(pPos);
        isWinner = ticTacToe.play(pos);

        return Integer.toString(ticTacToe.getSquare(pos));
    }

    @RequestMapping(value = "/winner", method = RequestMethod.GET)
    @ResponseBody
    public String winner() {
        return isWinner ? "yes" : "no";
    }

    @RequestMapping(value = "/restart", method = RequestMethod.GET)
    @ResponseBody
    public String restart() {
        ticTacToe.restart();

        return "restarted";
    }
}
