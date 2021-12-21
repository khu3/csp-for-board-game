package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int row = scn.nextInt();
        int column = scn.nextInt();
        int[] positive_row = new int[row];
        int[] negative_row = new int[row];
        int[] positive_column = new int[column];
        int[] negative_column = new int[column];
        for (int i = 0; i < row; i++) {
            positive_row[i] = scn.nextInt();
        }
        for (int i = 0; i < row; i++) {
            negative_row[i] = scn.nextInt();
        }
        for (int i = 0; i < column; i++) {
            positive_column[i] = scn.nextInt();
        }
        for (int i = 0; i < column; i++) {
            negative_column[i] = scn.nextInt();
        }
        int[][] board = new int[row][column];
        boolean[][] available_block = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                board[i][j] = scn.nextInt();
                available_block[i][j] = true;
            }
        }
        Variable[] variables = new Variable[(row * column)/2];
        int counter = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (available_block[i][j]){
                    if (board[i][j] == 1){
                        variables[counter] = new Variable(true, i, j);
                        available_block[i][j] = false;
                        available_block[i+1][j] = false;
                    }
                    else {
                        variables[counter] = new Variable(false, i, j);
                        available_block[i][j] = false;
                        available_block[i][j+1] = false;
                    }
                    counter++;
                }
            }
        }
    }
}
