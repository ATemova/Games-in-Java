import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class HangmanGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"java", "python", "hangman", "programming"};
        String wordToGuess = words[(int) (Math.random() * words.length)];
        StringBuilder guessedWord = new StringBuilder("_".repeat(wordToGuess.length()));
        Set<Character> guessedLetters = new HashSet<>();
        int attemptsLeft = 7;

        System.out.println("Welcome to Hangman! Try to guess the word:");
        while (attemptsLeft > 0 && guessedWord.indexOf("_") != -1) {
            System.out.println("Current word: " + guessedWord);
            System.out.println("Attempts left: " + attemptsLeft);
            System.out.println("Guess a letter:");
            char guess = scanner.nextLine().charAt(0);

            if (guessedLetters.contains(guess)) {
                System.out.println("You've already guessed that letter.");
                continue;
            }

            guessedLetters.add(guess);
            boolean correctGuess = false;

            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    guessedWord.setCharAt(i, guess);
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                attemptsLeft--;
                System.out.println("Wrong guess!");
            }
        }

        if (guessedWord.indexOf("_") == -1) {
            System.out.println("Congratulations! You guessed the word: " + wordToGuess);
        } else {
            System.out.println("Game over! The word was: " + wordToGuess);
        }

        scanner.close();
    }
}
