import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SimplePong extends JPanel implements Runnable {

    private int ballX = 150, ballY = 100, ballXDirection = 2, ballYDirection = 2;
    private int paddle1Y = 100, paddle2Y = 100;
    private int paddleWidth = 10, paddleHeight = 60;

    public SimplePong() {
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    paddle2Y -= 15;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    paddle2Y += 15;
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);

        // Draw ball
        g.fillOval(ballX, ballY, 20, 20);

        // Draw paddles
        g.fillRect(20, paddle1Y, paddleWidth, paddleHeight);
        g.fillRect(getWidth() - 30, paddle2Y, paddleWidth, paddleHeight);

        // Ball movement logic
        ballX += ballXDirection;
        ballY += ballYDirection;

        if (ballX <= 30 && ballY > paddle1Y && ballY < paddle1Y + paddleHeight) {
            ballXDirection = -ballXDirection;
        }

        if (ballX >= getWidth() - 50 && ballY > paddle2Y && ballY < paddle2Y + paddleHeight) {
            ballXDirection = -ballXDirection;
        }

        if (ballX <= 0 || ballX >= getWidth() - 20) {
            ballXDirection = -ballXDirection;
        }

        if (ballY <= 0 || ballY >= getHeight() - 20) {
            ballYDirection = -ballYDirection;
        }

        repaint();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Pong");
        SimplePong pong = new SimplePong();
        frame.add(pong);
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Thread gameThread = new Thread(pong);
        gameThread.start();
    }
}
