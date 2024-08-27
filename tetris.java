import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tetris extends JPanel implements ActionListener, KeyListener {
    private static final int GRID_SIZE = 10;
    private static final int BLOCK_SIZE = 30;
    private Timer timer;

    public Tetris() {
        timer = new Timer(500, this);
        timer.start();
        setPreferredSize(new Dimension(GRID_SIZE * BLOCK_SIZE, GRID_SIZE * BLOCK_SIZE));
        addKeyListener(this);
        setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(100, 100, BLOCK_SIZE, BLOCK_SIZE); // Simplified block
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Tetris());
        frame.pack();
        frame.setVisible(true);
    }
}
