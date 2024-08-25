import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HangmanGUI {
    private static final String[] WORDS = {"java", "python", "hangman", "programming"};
    private static String wordToGuess;
    private static StringBuilder guessedWord;
    private static Set<Character> guessedLetters;
    private static int attemptsLeft;
    private static JFrame frame;
    private static JLabel wordLabel;
    private static JLabel attemptsLabel;
    private static JTextField guessField;
    private static JButton guessButton;
    private static JTextArea resultArea;

    public static void main(String[] args) {
        setupGame();
        createGUI();
    }

    private static void setupGame() {
        Random random = new Random();
        wordToGuess = WORDS[random.nextInt(WORDS.length)];
        guessedWord = new StringBuilder("_".repeat(wordToGuess.length()));
        guessedLetters = new HashSet<>();
        attemptsLeft = 7;
    }

    private static void createGUI() {
        frame = new JFrame("Hangman Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        wordLabel = new JLabel("Word: " + guessedWord.toString(), JLabel.CENTER);
        attemptsLabel = new JLabel("Attempts left: " + attemptsLeft, JLabel.CENTER);
        guessField = new JTextField(1);
        guessButton = new JButton("Guess");
        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleGuess();
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter a letter:"));
        panel.add(guessField);
        panel.add(guessButton);

        frame.add(wordLabel, BorderLayout.NORTH);
        frame.add(attemptsLabel, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);
        frame.add(new JScrollPane(resultArea), BorderLayout.EAST);

        frame.pack();
        frame.setVisible(true);
    }

    private static void handleGuess() {
        String guess = guessField.getText().toLowerCase();
        if (guess.length() != 1) {
            JOptionPane.showMessageDialog(frame, "Please enter only one letter.");
            return;
        }

        char guessedLetter = guess.charAt(0);
        if (guessedLetters.contains(guessedLetter)) {
            JOptionPane.showMessageDialog(frame, "You've already guessed that letter.");
            return;
        }

        guessedLetters.add(guessedLetter);
        boolean correctGuess = false;

        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guessedLetter) {
                guessedWord.setCharAt(i, guessedLetter);
                correctGuess = true;
            }
        }

        if (correctGuess) {
            resultArea.append("Correct guess: " + guessedLetter + "\n");
        } else {
            attemptsLeft--;
            resultArea.append("Wrong guess: " + guessedLetter + "\n");
        }

        if (guessedWord.indexOf("_") == -1) {
            resultArea.append("Congratulations! You've guessed the word: " + wordToGuess + "\n");
            guessButton.setEnabled(false);
        } else if (attemptsLeft <= 0) {
            resultArea.append("Game over! The word was: " + wordToGuess + "\n");
            guessButton.setEnabled(false);
        }

        wordLabel.setText("Word: " + guessedWord.toString());
        attemptsLabel.setText("Attempts left: " + attemptsLeft);
        guessField.setText("");
    }
}
