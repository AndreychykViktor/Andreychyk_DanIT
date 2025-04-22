import java.util.Scanner;

public class hm1 {
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

      static void Game1(String name) {
          Scanner sc = new Scanner(System.in);
          System.out.println("Let the game begin!");
          int[] history_of_numbers = new int[101];
          int user_number;
          int interarations = 1;
          int randomNumber = (int) (Math.random() * 100);
          while(true) {
              String numberString = sc.nextLine();
              try {
                  user_number = Integer.parseInt(numberString);
              } catch (NumberFormatException e) {
                  System.out.println("Invalid number format");
                  continue;
              }

              history_of_numbers[user_number]++;
              if (user_number == randomNumber) {
                  System.out.println("Congratulations " + name);
                  System.out.println("Random number was: " + randomNumber);
                  break;
              }
              if (user_number > 100 || user_number < 0) {
                  System.out.println("Please enter a number between 0 and 100");
              }
              if (user_number > randomNumber) {
                  System.out.println("Your number is too high. Please, try again..");

              }
              if (user_number < randomNumber) {
                  System.out.println("Your number is too low. Please, try again..");

              }
              interarations++;
          }
          System.out.print("Your numbers: ");
          for (int i = history_of_numbers.length - 1; i > 0; i--) { //need to use this method for controling {0}
              if(history_of_numbers[i] > 0) {
                  System.out.printf("%d ", i);
              }
          }
          System.out.println();
          System.out.println("Count of try " + interarations);
      }


      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = sc.nextLine();

        Game1(name);

      }
}
