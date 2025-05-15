package com.ghostas;

import com.ghostas.exception.CellAlreadyOccupiedException;
import com.ghostas.exception.ValueOutOfBoundsException;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Driver class for the TicTacToe game
 * Checks for valid input
 *
 * @author ghostas
 * @version 0.1
 *
 * @see #main(String[])
 */
public class TicTacToeDriver {

    public static void main(String[] args) {

        TicTacToe game = TicTacToe.createTicTacToe();
        Scanner in = new Scanner(System.in);
        int player = 1;
        int row, col;

        do {
            System.out.println("Player " + player + "'s turn");
            System.out.println("Enter row,col: " );
            try {
                if (game.getTurn() == 10) break;

                row = in.nextInt();
                col = in.nextInt();

                game.setValue(row, col, player);

                game.printBoard();

                // ternary operator:
                player = (game.checkForWinner()) ? player : (player % 2 == 0) ? 1 : 2;



            } catch (InputMismatchException e) {
                System.out.println("Please enter valid numbers");
                in.nextLine();
            } catch (ValueOutOfBoundsException e) {
                System.out.println("Enter valid numbers");
            } catch (CellAlreadyOccupiedException e) {
                System.out.println("Cell already occupied");
            }



        } while (!game.checkForWinner());

        System.out.println("We have a winner: " + player);
    }
}
