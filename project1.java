import java.util.Scanner;
import java.util.Random;

public class project1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numberToGuess = random.nextInt(100) + 1; // random number between 1-100.
        int attempts = 0; // 0 attempts at the starting
        boolean hasGuessedCorrectly = false; // at the starting the guess will be false or wrong

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have chosen a number between 1 and 100.");
        System.out.println("Can you guess it?");

        while (!hasGuessedCorrectly) { // if the guess is false or wrong the loop will run until correct guess
            System.out.print("Enter your guess: ");
            int playerGuess = scanner.nextInt();
            attempts++;

            if (playerGuess < numberToGuess) {
                System.out.println("The Number Guessed is Too low! Try again.");
            } else if (playerGuess > numberToGuess) {
                System.out.println("The Number Guessed is Too high! Try again.");
            } else {
                hasGuessedCorrectly = true;
                System.out.println("Congratulations! and the number is "+playerGuess+" and You guessed the number in " + attempts + " attempts.");
                System.out.println("Thank You for playing the Game");
            }
        }

    }
}
