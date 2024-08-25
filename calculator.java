import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Calculator");
        JTextField inputField = new JTextField(15);
        JButton addButton = new JButton("Add");
        JButton subtractButton = new JButton("Subtract");
        JLabel resultLabel = new JLabel("Result: ");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] numbers = inputField.getText().split("\\+");
                if (numbers.length == 2) {
                    try {
                        int num1 = Integer.parseInt(numbers[0].trim());
                        int num2 = Integer.parseInt(numbers[1].trim());
                        resultLabel.setText("Result: " + (num1 + num2));
                    } catch (NumberFormatException ex) {
                        resultLabel.setText("Invalid input!");
                    }
                }
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] numbers = inputField.getText().split("-");
                if (numbers.length == 2) {
                    try {
                        int num1 = Integer.parseInt(numbers[0].trim());
                        int num2 = Integer.parseInt(numbers[1].trim());
                        resultLabel.setText("Result: " + (num1 - num2));
                    } catch (NumberFormatException ex) {
                        resultLabel.setText("Invalid input!");
                    }
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter expression:"));
        panel.add(inputField);
        panel.add(addButton);
        panel.add(subtractButton);
        panel.add(resultLabel);

        frame.add(panel);
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
