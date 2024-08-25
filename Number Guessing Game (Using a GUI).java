import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuessingGameGUI {
    private static int numberToGuess;
    private static int numberOfTries;

    public static void main(String[] args) {
        Random random = new Random();
        numberToGuess = random.nextInt(100) + 1;
        numberOfTries = 0;

        JFrame frame = new JFrame("Number Guessing Game");
        JTextField guessField = new JTextField(10);
        JButton guessButton = new JButton("Guess");
        JLabel resultLabel = new JLabel("Guess a number between 1 and 100");

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int userGuess = Integer.parseInt(guessField.getText());
                numberOfTries++;
                if (userGuess < numberToGuess) {
                    resultLabel.setText("Too low! Try again.");
                } else if (userGuess > numberToGuess) {
                    resultLabel.setText("Too high! Try again.");
                } else {
                    resultLabel.setText("Congratulations! You guessed the number in " + numberOfTries + " tries.");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter your guess:"));
        panel.add(guessField);
        panel.add(guessButton);
        panel.add(resultLabel);

        frame.add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
