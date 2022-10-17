package com.company;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println();
        Scanner sc = new Scanner(System.in);
        int input = 0;
        while(input != 3) {
            System.out.println("Play Against (1)-Another Person or (2)-Computer? Type '3' to quit.");
            input = sc.nextInt();

            if (input == 1) {
                play();
            } else if (input == 2) {
                playComputer();
            } else if (input != 3){
                System.out.println("Invalid Input.");
            }
        }

    }

    public static void playComputer()
    {
        char[][] board = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
        int col;
        int row;

        Scanner gameSc = new Scanner(System.in);
        Random rand = new Random();

        boolean player1 = true;
        boolean gameEnd = false;
        printBoard(board);

        while(!gameEnd)
        {
            if(player1){
                System.out.print("Player 1, ");
                System.out.println("Enter Row (1-3): ");
                row = gameSc.nextInt();

                System.out.println("Enter Column (1-3): ");
                col = gameSc.nextInt();

                while (board[col-1][row-1] != '-')
                {
                    System.out.println("Invalid Position");

                    if(player1){
                        System.out.print("Player 1, ");
                    }
                    else{
                        System.out.print("Player 2, ");
                    }
                    System.out.println("Enter Row (1-3): ");
                    row = gameSc.nextInt();

                    System.out.println("Enter Column (1-3): ");
                    col = gameSc.nextInt();
                }
            }
            else
            {
                row = rand.nextInt((3 - 1) + 1) + 1;
                col = rand.nextInt((3 - 1) + 1) + 1;

                while (board[col-1][row-1] != '-') {
                    row = rand.nextInt((3 - 1) + 1) + 1;
                    col = rand.nextInt((3 - 1) + 1) + 1;
                }
                System.out.println();
            }

            if(player1)
            {
                board[col-1][row-1] = 'x';
            }
            else
            {
                board[col-1][row-1] = 'o';
            }



            printBoard(board);

            if(playerWin(board))
            {
                gameEnd = true;
                if(player1){
                    System.out.println("Player 1 Wins!");
                }
                else{
                    System.out.println("Player 2 Wins!");
                }

            }
            else
            {
                player1 = !player1;
            }

        }


    }
    public static void play()
    {
        char[][] board = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
        int col;
        int row;

        Scanner gameSc = new Scanner(System.in);

        boolean player1 = true;
        boolean gameEnd = false;
        printBoard(board);

        while(!gameEnd)
        {
            if(player1){
                System.out.print("Player 1, ");
            }
            else{
                System.out.print("Player 2, ");
            }
            System.out.println("Enter Row (1-3): ");
            row = gameSc.nextInt();

            System.out.println("Enter Column (1-3): ");
            col = gameSc.nextInt();

            while (board[col-1][row-1] != '-')
            {
                System.out.println("Invalid Position");

                if(player1){
                    System.out.print("Player 1, ");
                }
                else{
                    System.out.print("Player 2, ");
                }
                System.out.println("Enter Row (1-3): ");
                row = gameSc.nextInt();

                System.out.println("Enter Column (1-3): ");
                col = gameSc.nextInt();
            }
            if(player1)
            {
                board[col-1][row-1] = 'x';
            }
            else
            {
                board[col-1][row-11] = 'o';
            }



            printBoard(board);

            if(playerWin(board))
            {
                gameEnd = true;
                if(player1){
                    System.out.print("Player 1 Wins!");
                }
                else{
                    System.out.print("Player 2 Wins!");
                }

            }
            else
            {
                player1 = !player1;
            }

        }


    }

    public static boolean playerWin(char[][] board)
    {

        for(int i = 0; i < board.length; i++)
        {
            if(board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2])
            {
                return true;
            }
            if(board[0][i] != '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i])
            {
                return true;
            }

        }
        if(board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2])
        {
            return true;
        }
        if(board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0])
        {
            return true;
        }

        return false;
    }



    public static void printBoard(char[][] board)
    {
        for(int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
