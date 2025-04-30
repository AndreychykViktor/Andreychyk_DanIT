package hm3;

import java.util.Scanner;
public class hm3 {
    public static void main(String[] args) {
        String[][] schedule = new String[7][2];
        schedule[0][0] = "Sunday";
        schedule[0][1] = "do home work 1";
        schedule[1][0] = "Monday";
        schedule[1][1] = "do home work 2";
        schedule[2][0] = "Tuesday";
        schedule[2][1] = "do home work 3";
        schedule[3][0] = "Wednesday";
        schedule[3][1] = "do home work 4";
        schedule[4][0] = "Thursday";
        schedule[4][1] = "do home work 5";
        schedule[5][0] = "Friday";
        schedule[5][1] = "do home work 6";
        schedule[6][0] = "Saturday";
        schedule[6][1] = "do home work 7";

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please, input the day of the week:");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

            if (input.startsWith("change ")) {
                String dayToChange = input.replaceFirst("change ", "").trim();
                boolean found = false;

                for (String[] day : schedule) {
                    if (day[0].toLowerCase().equals(dayToChange)) {
                        System.out.println("Please, input new tasks for " + day[0] + ":");
                        String newTasks = scanner.nextLine().trim();
                        day[1] = newTasks;
                        System.out.println("Tasks for " + day[0] + " have been updated.");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Sorry, I don't understand you, please try again.");
                }
                continue;
            }

            boolean found = false;
            for (String[] day : schedule) {
                if (day[0].toLowerCase().equals(input)) {
                    System.out.println("Your tasks for " + day[0] + ": " + day[1] + ".");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Sorry, I don't understand you, please try again.");
            }
        }
    }
}

