import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleFarm extends JFrame {
    private JButton[][] plots = new JButton[3][3];
    private String[] states = {"Empty", "Planted", "Harvested"};
    private int[][] plotStates = new int[3][3];

    public SimpleFarm() {
        setTitle("Simple Farm");
        setSize(300, 300);
        setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                plots[i][j] = new JButton(states[plotStates[i][j]]);
                add(plots[i][j]);

                // Add action listener for each plot
                final int row = i;
                final int col = j;
                plots[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (plotStates[row][col] == 0) {
                            plotStates[row][col] = 1;
                        } else if (plotStates[row][col] == 1) {
                            plotStates[row][col] = 2;
                        } else if (plotStates[row][col] == 2) {
                            plotStates[row][col] = 0;
                        }
                        plots[row][col].setText(states[plotStates[row][col]]);
                    }
                });
            }
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleFarm();
    }
}
