import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SimplePlatformer extends JPanel {

    private int playerX = 50;
    private int playerY = 300;
    private int playerWidth = 50;
    private int playerHeight = 50;
    private int groundLevel = 350;
    private boolean isJumping = false;
    private int jumpSpeed = 15;
    private int fallSpeed = 5;

    public SimplePlatformer() {
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT) {
                    playerX -= 10;
                }
                if (key == KeyEvent.VK_RIGHT) {
                    playerX += 10;
                }
                if (key == KeyEvent.VK_SPACE && !isJumping) {
                    isJumping = true;
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw ground
        g.setColor(Color.GREEN);
        g.fillRect(0, groundLevel, getWidth(), 50);

        // Draw player
        g.setColor(Color.RED);
        g.fillRect(playerX, playerY, playerWidth, playerHeight);

        // Handle jumping
        if (isJumping) {
            playerY -= jumpSpeed;
            if (playerY <= groundLevel - 100) {
                isJumping = false;
            }
        } else if (playerY < groundLevel - playerHeight) {
            playerY += fallSpeed;
        } else {
            playerY = groundLevel - playerHeight;
        }

        // Repaint the component
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Platformer");
        SimplePlatformer platformer = new SimplePlatformer();
        frame.add(platformer);
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
