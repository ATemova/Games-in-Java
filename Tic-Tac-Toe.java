import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame {

    private JButton[] buttons = new JButton[9];
    private boolean xTurn = true;

    public TicTacToe() {
        setTitle("Tic-Tac-Toe");
        setSize(300, 300);
        setLayout(new GridLayout(3, 3));

        // Initialize buttons
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 60));
            add(buttons[i]);

            // Add action listener to each button
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton buttonClicked = (JButton) e.getSource();
                    if (buttonClicked.getText().equals("")) {
                        buttonClicked.setText(xTurn ? "X" : "O");
                        xTurn = !xTurn;
                        checkWin();
                    }
                }
            });
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Method to check if there's a winner
    private void checkWin() {
        String[][] combos = {
            {buttons[0].getText(), buttons[1].getText(), buttons[2].getText()},
            {buttons[3].getText(), buttons[4].getText(), buttons[5].getText()},
            {buttons[6].getText(), buttons[7].getText(), buttons[8].getText()},
            {buttons[0].getText(), buttons[3].getText(), buttons[6].getText()},
            {buttons[1].getText(), buttons[4].getText(), buttons[7].getText()},
            {buttons[2].getText(), buttons[5].getText(), buttons[8].getText()},
            {buttons[0].getText(), buttons[4].getText(), buttons[8].getText()},
            {buttons[2].getText(), buttons[4].getText(), buttons[6].getText()}
        };

        for (String[] combo : combos) {
            if (combo[0].equals(combo[1]) && combo[1].equals(combo[2]) && !combo[0].equals("")) {
                JOptionPane.showMessageDialog(this, combo[0] + " wins!");
                resetBoard();
                return;
            }
        }

        // Check for draw
        boolean draw = true;
        for (JButton button : buttons) {
            if (button.getText().equals("")) {
                draw = false;
                break;
            }
        }
        if (draw) {
            JOptionPane.showMessageDialog(this, "Draw!");
            resetBoard();
        }
    }

    // Method to reset the board after a win/draw
    private void resetBoard() {
        for (JButton button : buttons) {
            button.setText("");
        }
        xTurn = true;
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}
