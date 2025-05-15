package com.ghostas;

import com.ghostas.exception.CellAlreadyOccupiedException;
import com.ghostas.exception.ValueOutOfBoundsException;

/**
 * TicTacToe class (POJO)
 * and provides the methods for the TicTacToe game
 *
 * @author ghostas
 * @version 0.1
 *
 * @see #TicTacToe()
 * @see #createTicTacToe()
 * @see #printBoard()
 * @see #setValue(int, int, int)
 * @see #checkForWinner()
 */
public class TicTacToe {

    /**
     * - 'board' points to the heap
     * - at the heap, the table will be created with the 'new', that it will create 9 int indexes (3x3)
     * - 'board' exists in the stack of the memory (at the compile time), and
     * - the 'new int' comes at the runtime (kata ton xrono ektelsis)
     */
    private int[][] board = new int[3][3];

    private int turn = 0; // total 9 turns

    //? we can make the constructor private, to make the users use only the static factory method
    private TicTacToe() {
        // because we have to do with data structures (int[][]), its ok to initialize the board outside of the constructor
    }

    /**
     * Static Factory Method (it's like a constructor)
     * Pros:
     * - it's more readable
     * - we can give the names we want
     *
     * Cons:
     * - if we change the name of the class we have to rename the static factory method manually
     *
     * @return one object of the class (TicTacToe)
     */
    public static TicTacToe createTicTacToe() {

        return new TicTacToe();
    }

    public void printBoard() {
        for (int[] row : board) {
            for (int col : row) {
                System.out.print(col + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Sets the value 0 or 1 at the given position row,col
     * @param row
     * @param col
     * @param value 1 or 2
     */
    public void setValue(int row, int col, int value) throws ValueOutOfBoundsException, CellAlreadyOccupiedException {
        if ((row < 0 || row > 2 || col < 0 || col > 2) ||
                value != 1 && value != 2) { // if the row or col is out of bounds of the board
            throw new ValueOutOfBoundsException();
        }

        if (board[row][col] != 0) {
            throw new CellAlreadyOccupiedException();
        } else {
            if (++turn == 10) return;
            board[row][col] = value;
        }
    }

    /**
     * Checks if there is a winner
     * @return true if there is a winner, false otherwise
     */
    public boolean checkForWinner() {
        return (

                /** DIAGONALS **/
                // 1st diagonal
                (
                        (board[0][0] == board[1][1] && board[1][1] == board[2][2]) &&
                        (board[1][1] != 0)
                ) ||
                // 2nd diagonal
                (
                        (board[0][2] == board[1][1] && board[1][1] == board[2][0]) &&
                        (board[1][1] != 0)
                ) ||

                /** ROWS **/
                // 1st row
                (
                        (board[0][0] == board[0][1] && board[0][1] == board[0][2]) &&
                        (board[0][1] != 0)
                ) ||
                // 2nd row
                (
                        (board[1][0] == board[1][1] && board[1][1] == board[1][2]) &&
                        (board[1][1] != 0)

                ) ||
                // 3rd row
                (
                        (board[2][0] == board[2][1] && board[2][1] == board[2][2]) &&
                        (board[2][1] != 0)
                ) ||

                /** COLUMNS **/
                // 1st column
                (
                        (board[0][0] == board[1][0] && board[1][0] == board[2][0]) &&
                        (board[0][1] != 0)
                ) ||
                // 2nd column
                (
                        (board[0][1] == board[1][1] && board[1][1] == board[2][1]) &&
                        (board[1][1]!= 0)
                ) ||
                // 3rd column
                (
                        (board[0][2] == board[1][2] && board[1][2] == board[2][2]) &&
                        (board[2][1] != 0)
                )



        );
    }

    // Getter and Setter
    public int getTurn() { return turn; }
    public void setTurn(int turn) { this.turn = turn; }

}





















