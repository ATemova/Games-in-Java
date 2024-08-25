import java.util.Scanner;

public class GuessTheWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"java", "python", "javascript", "html", "css"};
        String wordToGuess = words[(int) (Math.random() * words.length)];
        StringBuilder guessedWord = new StringBuilder("_".repeat(wordToGuess.length()));
        int attemptsLeft = 6;

        System.out.println("Guess the word: " + guessedWord);
        while (attemptsLeft > 0 && guessedWord.indexOf("_") != -1) {
            System.out.println("Enter a letter:");
            char guess = scanner.nextLine().charAt(0);
            boolean correctGuess = false;

            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    guessedWord.setCharAt(i, guess);
                    correctGuess = true;
                }
            }

            if (correctGuess) {
                System.out.println("Good guess! " + guessedWord);
            } else {
                attemptsLeft--;
                System.out.println("Wrong guess. Attempts left: " + attemptsLeft);
            }
        }

        if (guessedWord.indexOf("_") == -1) {
            System.out.println("Congratulations! You've guessed the word: " + wordToGuess);
        } else {
            System.out.println("Sorry, you ran out of attempts. The word was: " + wordToGuess);
        }

        scanner.close();
    }
}
