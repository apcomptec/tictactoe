package com.model;

/**
 * Created by brallan on 09/06/16.
 */
public class TicTacToeModel {

    private final int SIZE;

    /**
     * if true, is player 1 turn, else is player 2 turn
     */
    private boolean turn;

    /**
     * playing zone. It has the next distribution:
     *
     * +---+---+---+
     * | 0 | 1 | 2 |
     * +---+---+---+
     * | 3 | 4 | 5 |
     * +---+---+---+
     * | 6 | 7 | 8 |
     * +---+---+---+
     *
     * if the player 1 has occupied certain square, it has the value 1
     * else if the player 2 has some square, it has a 2
     * finally if the square is empty, there is a 0
     */
    private int[] board;

    /**
     * Counter of moves
     */
    private int numberOfMoves;

    public TicTacToeModel() {
        SIZE = 9;
        board = new int[SIZE];
        turn = true;
        numberOfMoves = 0;
    }

    /**
     * Here occurs the verifications to find a winner
     * @param pPosition where a player is playing
     */
    public boolean play(int pPosition) {
        boolean isWinner = false;

        try {

            int empty = 0;

            if (board[pPosition] == empty) {
                int player1 = 1;
                int player2 = 2;

                board[pPosition] = turn ? player1 : player2;
                isWinner = checkWinner(pPosition);
                turn = !turn;
                numberOfMoves++;
            }
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }

        return isWinner;
    }

    /**
     * Verify if there is a winner
     * @param pPosition
     * @return
     */
    private boolean checkWinner(int pPosition) {
        boolean winnerColumn, winnerRow, winnerDiagonal;
        int columnToCheck, rowToCheck;

        if(pPosition < 3) { // first row
            columnToCheck = pPosition;
            rowToCheck = 0;
        }
        else if(pPosition < 6) { // second row
            columnToCheck = pPosition - 3;
            rowToCheck = 3;
        }
        else { // third row
            columnToCheck = pPosition - 6;
            rowToCheck = 6;
        }

        winnerColumn = checkColumn(columnToCheck);
        winnerRow = checkRow(rowToCheck);
        winnerDiagonal = (pPosition % 2 == 0) ? checkDiagonals() : false; // is pPosition in a diagonal?

        return winnerColumn || winnerRow || winnerDiagonal;
    }

    /**
     * Check if a player wins in a row
     * @param pPosition
     * @return
     */
    private boolean checkRow(int pPosition) {
        boolean statement;

        try {
            statement = (board[pPosition] == board[pPosition + 1]) &&
                    (board[pPosition + 1]  == board[pPosition + 2]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
            statement = false;
        }

        return statement;
    }

    /**
     * Check if a player wins in a column
     * @param pPosition
     * @return
     */
    private boolean checkColumn(int pPosition) {
        boolean statement;

        try {
            statement = (board[pPosition] == board[pPosition + 3]) &&
                    (board[pPosition + 3] == board[pPosition + 6]);
        }
        catch  (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
            statement = false;
        }

        return statement;
    }

    /**
     * Check for a winner at the diagonals
     * @return
     */
    private boolean checkDiagonals() {
        boolean statement;

        try {
            statement = ((board[0] != 0) && (board[0] == board[4]) && (board[4] == board[8])) ||
                    ((board[2] != 0) && (board[2] == board[4]) && (board[4] == board[6]));
        }
        catch  (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
            statement = false;
        }

        return statement;
    }

    /**
     *
     * @param pPosition
     * @return content of the square in pPosition
     */
    public int getSquare(int pPosition) {
        return board[pPosition];
    }

    /**
     *
     * @return Number of moves done
     */
    public int getNumberOfMoves() {
        return numberOfMoves;
    }

    /**
     * Restart the game
     */
    public void restart() {
        board = new int[SIZE];
        turn = true;
        numberOfMoves = 0;
    }
}
