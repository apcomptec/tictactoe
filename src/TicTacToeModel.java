/**
 * Created by brallan on 09/06/16.
 */
public class TicTacToeModel {

    private final int SIZE = 9;
    private final int EMPTY = 0;
    private final int PLAYER1 = 1;
    private final int PLAYER2 = 2;

    /**
     * if true, is player 1 turn, else is player 2 turn
     */
    private boolean turn = true;

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
     */
    private int[] board = new int[SIZE];

    /**
     * Here occurs the verifications to find a winner
     * @param pPosition where a player is playing
     */
    public void play(int pPosition) {
        try {
            if (board[pPosition] != EMPTY) {
                board[pPosition] = turn ? PLAYER1 : PLAYER2;
                checkWinner(pPosition);
            }
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

    /**
     * Verify if there is a winner
     * @param pPosition
     * @return
     */
    private boolean checkWinner(int pPosition) {
        boolean winnerColumn, winnerRow;
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

        return winnerColumn || winnerRow;
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
}
