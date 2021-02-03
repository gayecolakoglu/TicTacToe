package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        Board board = new Board();

        System.out.println(board);
        while (!board.isEnded()) {

            int player = board.getCurrentPlayer();

            int row=0;
            boolean flag=true;
            while (flag){
                System.out.print("Player " + player + " enter row number:");
                try {
                    row = Integer.valueOf(reader.nextLine());
                    flag=false;
                }catch (NumberFormatException e){
                    flag=true;
                }
            }
            int col=0;
            boolean flag2=true;
            while (flag2){
                System.out.print("Player " + player + " enter column number:");
                try {
                    col = Integer.valueOf(reader.nextLine());
                    flag2=false;
                }catch (NumberFormatException e){
                    flag2=true;
                }
            }

            try {
                board.move(row, col);
            }catch (InvalidMoveException e){
                System.out.println(e.getMessage());
            }
            System.out.println(board);
        }


        reader.close();
    }


}
