import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ColorMatrix extends JPanel implements ActionListener {
    private static final int SIZE = 100;
    private static final int CELL_SIZE = 10; // Size of each cell in pixels
    private static final int DELAY = 5000; // 5 seconds delay
    private Color[][] colors = new Color[SIZE][SIZE];
    private Timer timer;

    public ColorMatrix() {
        setPreferredSize(new Dimension(SIZE * CELL_SIZE, SIZE * CELL_SIZE));
        timer = new Timer(DELAY, this);
        timer.start();
        initializeColors();
    }

    private void initializeColors() {
        Random rand = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                g.setColor(colors[i][j]);
                g.fillRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        initializeColors();
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Color Matrix");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ColorMatrix());
        frame.pack();
        frame.setVisible(true);
    }
}
