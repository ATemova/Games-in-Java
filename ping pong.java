import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimplePingPong {
    private static int ballX = 250, ballY = 250;
    private static int ballDX = 1, ballDY = 1;
    private static final int BALL_SIZE = 20;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Ping Pong");
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
            }
        };

        panel.setPreferredSize(new Dimension(500, 500));
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Timer timer = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ballX += ballDX;
                ballY += ballDY;

                if (ballX <= 0 || ballX >= panel.getWidth() - BALL_SIZE) {
                    ballDX = -ballDX;
                }
                if (ballY <= 0 || ballY >= panel.getHeight() - BALL_SIZE) {
                    ballDY = -ballDY;
                }

                panel.repaint();
            }
        });

        timer.start();
    }
}
