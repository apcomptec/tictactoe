package model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by brallan on 24/06/16.
 */
public class TicTacToeModelTest {

    private TicTacToeModel ttt = new TicTacToeModel();

    @Test
    public void play() throws Exception {
//        // TEST 1
//        // O O O
//        // X X -
//        // - - -
//        assertFalse(ttt.play(0));
//        assertFalse(ttt.play(3));
//        assertFalse(ttt.play(1));
//        assertFalse(ttt.play(4));
//        assertTrue(ttt.play(2));

//        // TEST 2
//        // O X X
//        // X O O
//        // O O X
//        assertFalse(ttt.play(4));
//        assertFalse(ttt.play(8));
//        assertFalse(ttt.play(6));
//        assertFalse(ttt.play(2));
//        assertFalse(ttt.play(5));
//        assertFalse(ttt.play(3));
//        assertFalse(ttt.play(7));
//        assertFalse(ttt.play(1));
//        assertFalse(ttt.play(0));

        // TEST 3
        // - - O
        // X O -
        // O X -
        assertFalse(ttt.play(4));
        assertFalse(ttt.play(7));
        assertFalse(ttt.play(6));
        assertFalse(ttt.play(3));
        assertTrue(ttt.play(2));
    }

}