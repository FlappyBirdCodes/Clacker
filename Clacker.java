import java.util.*;

public class Clacker {

    // Shows board given an ArrayList of integers
    public static void show_board(ArrayList<Integer> numbers) {

        String board = "";
        for (int i=0; i<numbers.size(); i++) {
            // Moves to next line when appropriate
            if (i == 4 || i == 8) {
                board += System.lineSeparator();
            } 

            // Reassigns to X if equals -1 
            String new_number = Integer.toString(numbers.get(i));
            if (new_number.equals("-1")) {
                new_number = "X";
            }

            // Creates appropriate spacing for each line
            board += new_number + repeat(" ", 4 - new_number.length());
        }
        System.out.println(board);
    }

    // Repeats a string a certain amount of times
    public static String repeat(String s, int times) {
        if (times <= 0) return "";
        else return s + repeat(s, times-1);
    }

    // Simulates two dice rolls and returns an ArrayList of integers
    public static ArrayList<Integer> roll(ArrayList<Integer> numbers) {
        System.out.println("");

        Random random = new Random();

        // Generates two random numbers from 1 to 6
        int first_random = random.nextInt(6) + 1;
        int second_random = random.nextInt(6) + 1;

        // Displays the numbers rolled
        System.out.println("First number rolled: " + first_random);
        System.out.println("Second number rolled: " + second_random);

        // <ArrayList>.contains(<element>) checks if <element> is in the <ArrayList>
        if (!numbers.contains(first_random) && !numbers.contains(second_random)) {

            // Creates sum number if both elements are not found in list
            int sum_number = first_random + second_random;
            if (numbers.contains(sum_number) && sum_number >= 7) {

                // <ArrayList>.set(<index>, <value>) sets the <value> at <index>
                // <ArrayList>.indexOf(<element>) returns the index of <element> in the
                numbers.set(numbers.indexOf(sum_number), -1);
            }
        }
        // Checks if list contains element
        if (numbers.contains(first_random)) {
            numbers.set(numbers.indexOf(first_random), -1);
        }
        if (numbers.contains(second_random)) {
            numbers.set(numbers.indexOf(second_random), -1);
        }
        return numbers;
    }

    public static void play() {
        Scanner input = new Scanner(System.in);

        // Initializes an ArrayList, which is a data structure in Java that can hold multiple pieces of the same data type
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        // Adding numbers from 1 to 12 into the ArrayList
        for (int i = 1; i <= 12; i++) {
            numbers.add(i);
        }

        // Asks user for their name
        System.out.println("What is your name?");
        String name = input.nextLine();

        // Asks user for the number of rolls
        System.out.println("How many rolls do you want to attempt? (between 1 and 30)");
        int rolls = input.nextInt();

        // Checks if user has entered a valid input
        while (rolls < 1 || rolls > 30) {
            System.out.println("You must enter a number between 1 and 30.");
            System.out.println("How many rolls do you want to attempt? (between 1 and 30)");
            rolls = input.nextInt();
        }

        int i=0;
        while (i < rolls) {

            // Rolls dices and shows the board
            numbers = roll(numbers);
            show_board(numbers);

            int score = i + 1;
            System.out.println(name + "'s score: " + score);

            // Calculates rolls left
            int rolls_left = rolls - i - 1;
            System.out.println("Rolls left: " + rolls_left);  

            // Breaks loop if the entire board has been filled in
            if (Collections.frequency(numbers, -1) == 12) {
                System.out.println("The entire board has been filled.");
                break;
            }

            // Runs if all rolls have been completed, but the board still hasn't been filled completely
            if (rolls_left == 0 && Collections.frequency(numbers, -1) != 12) {
                
                System.out.println("All your rolls have been completed, but the board has not been filled.");
                System.out.println("Enter how many rolls you would like to do next (between 1 and 30):");
                rolls = input.nextInt();

                // Checks if user has entered a valid input
                while (rolls < 1 || rolls > 30) {
                    System.out.println("You must enter a number between 1 and 30.");
                    System.out.println("How many rolls do you want to attempt? (between 1 and 30)");
                    rolls = input.nextInt();
                }
                rolls = rolls + score;
            }
            i++;
        }
    }

    public static void main(String[] args) {

        // Runs program game_over evaluates to false
        boolean game_over = false;
        while (game_over == false) {
            play();

            // Asks user if they would like to play again
            String play_again = "";
            while (!play_again.equals("y") || !play_again.equals("n")) {

                // Asks user if they would like to play again
                System.out.println("Would you like to play again? (y/n)");
                Scanner scanner = new Scanner(System.in);
                play_again = scanner.nextLine();
                
                // Continues to run program if user chooses to play again
                if (play_again.equals("y")) {
                    System.out.println("");
                    play();
                } 

                // Breaks out of loop if user chooses to not play again
                else if (play_again.equals("n")) {
                    game_over = true;
                    System.out.print("Thank you for playing");
                    break;
                }

                else {
                    System.out.println("Invalid input, enter y/n");
                }
            }
        }
    }
}