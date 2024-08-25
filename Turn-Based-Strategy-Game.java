import javax.swing.*;
import java.awt.*;

public class SimpleChessBoard extends JPanel {

    public SimpleChessBoard() {
        setLayout(new GridLayout(8, 8));
        boolean white = true;

        // Create the chessboard grid
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                JPanel square = new JPanel();
                square.setBackground(white ? Color.WHITE : Color.GRAY);
                add(square);
                white = !white;
            }
            white = !white;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Chess Board");
        SimpleChessBoard board = new SimpleChessBoard();
        frame.add(board);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
