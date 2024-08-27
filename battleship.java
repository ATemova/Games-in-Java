import java.util.Random;

public class Battleship {
    private static final int SIZE = 10;
    private static final int SHIP_SIZE = 3;
    private static char[][] board = new char[SIZE][SIZE];
    private static boolean[][] shipBoard = new boolean[SIZE][SIZE];
    private static Random rand = new Random();

    public static void main(String[] args) {
        initializeBoard();
        placeShip();
        printBoard();
        System.out.println("Enter your guess (row and column):");
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        if (guess(row, col)) {
            System.out.println("Hit!");
        } else {
            System.out.println("Miss.");
        }
        printBoard();
    }

    private static void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '.';
            }
        }
    }

    private static void placeShip() {
        int dir = rand.nextInt(2);
        int row = rand.nextInt(SIZE);
        int col = rand.nextInt(SIZE);

        if (dir == 0) { // Horizontal
            if (col + SHIP_SIZE <= SIZE) {
                for (int i = 0; i < SHIP_SIZE; i++) {
                    shipBoard[row][col + i] = true;
                }
            }
        } else { // Vertical
            if (row + SHIP_SIZE <= SIZE) {
                for (int i = 0; i < SHIP_SIZE; i++) {
                    shipBoard[row + i][col] = true;
                }
            }
        }
    }

    private static boolean guess(int row, int col) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) return false;
        if (shipBoard[row][col]) {
            board[row][col] = 'X';
            return true;
        } else {
            board[row][col] = 'O';
            return false;
        }
    }

    private static void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
