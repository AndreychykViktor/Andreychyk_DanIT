package hm2;

import java.util.Scanner;
import java.util.logging.ConsoleHandler;

public class hm2 {
    static void printTable(char[][] bord) {
        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                for (int j = 0; j < 5; j++) {
                    System.out.printf(" %d |", j);
                }
                System.out.println(" 5 |");
            }else{
                for (int j = 0; j < 5; j++) {
                    if (j == 0) {
                        System.out.printf(" %d |", i);
                    } else if (bord[i][j] == '*') {
                        System.out.print(" * |");
                    } else if (bord[i][j] == 'X') {
                        System.out.print(" X |");
                    } else {
                        System.out.print(" - |");
                    }
                }
                if (bord[i][5] == '*') {
                    System.out.println(" * |");
                } else if (bord[i][5] == 'X') {
                    System.out.println(" X |");
                } else {
                    System.out.println(" - |");
                }
            }
            System.out.println();
        }
    }


    static void Game2(String name) {
        int randomAimRow = (int) (Math.random() * 5) + 1;
        int randomAimColumn = (int) (Math.random() * 5) + 1;
        Scanner sc = new Scanner(System.in);
        //System.out.printf("%d %d\n",randomAimRow, randomAimColumn);
        System.out.println("Let the game begin!");
        char[][] bord = new char[6][6];
        int user_row, user_column;

        while(true) {
            System.out.println("Enter the number of row (0-5): ");
            String numberStringRow = sc.nextLine();
            try {
                user_row = Integer.parseInt(numberStringRow);
                if(user_row > 5 || user_row < 0) {
                    System.out.println("Invalid number value");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format");
                continue;
            }
            System.out.println("Enter the number of column (0-5): ");
            String numberStringColumn = sc.nextLine();
            try {
                user_column = Integer.parseInt(numberStringColumn);
                if(user_column > 5 || user_column < 0) {
                    System.out.println("Invalid number value");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format");
                continue;
            }
            bord[user_row][user_column] = '*';
            if (user_row == randomAimRow && user_column == randomAimColumn) {
                System.out.println("You have won!");
                bord[user_row][user_column] = 'X';
                printTable(bord);
                break;
            }else{
                printTable(bord);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("All Set. Get ready to rumble!");
        String name = sc.nextLine();

        Game2(name);

    }
}
