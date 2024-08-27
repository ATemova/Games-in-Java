import java.util.Scanner;

public class ConnectFour {
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private static char[][] board = new char[ROWS][COLS];
    private static char currentPlayer = 'R';

    public static void main(String[] args) {
        initializeBoard();
        boolean running = true;
        while (running) {
            printBoard();
            int col = playerMove();
            if (dropDisk(col)) {
                if (checkWin()) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    running = false;
                } else if (isBoardFull()) {
                    printBoard();
                    System.out.println("It's a draw!");
                    running = false;
                } else {
                    currentPlayer = (currentPlayer == 'R') ? 'Y' : 'R';
                }
            }
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = '.';
            }
        }
    }

    private static void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int playerMove() {
        Scanner scanner = new Scanner(System.in);
        int col;
        do {
            System.out.print("Player " + currentPlayer + ", choose a column (0-6): ");
            col = scanner.nextInt();
        } while (col < 0 || col >= COLS || board[0][col] != '.');
        return col;
    }

    private static boolean dropDisk(int col) {
        for (int row = ROWS - 1; row >= 0; row--) {
            if (board[row][col] == '.') {
                board[row][col] = currentPlayer;
                return true;
            }
        }
        return false;
    }

    private static boolean checkWin() {
        return checkHorizontal() || checkVertical() || checkDiagonal();
    }

    private static boolean checkHorizontal() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col <= COLS - 4; col++) {
                if (board[row][col] != '.' && board[row][col] == board[row][col + 1] && 
                    board[row][col] == board[row][col + 2] && board[row][col] == board[row][col + 3]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkVertical() {
        for (int col = 0; col < COLS; col++) {
            for (int row = 0; row <= ROWS - 4; row++) {
                if (board[row][col] != '.' && board[row][col] == board[row + 1][col] && 
                    board[row][col] == board[row + 2][col] && board[row][col] == board[row + 3][col]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkDiagonal() {
        for (int row = 0; row <= ROWS - 4; row++) {
            for (int col = 0; col <= COLS - 4; col++) {
                if (board[row][col] != '.' && board[row][col] == board[row + 1][col + 1] && 
                    board[row][col] == board[row + 2][col + 2] && board[row][col] == board[row + 3][col + 3]) {
                    return true;
                }
            }
        }
        for (int row = 3; row < ROWS; row++) {
            for (int col = 0; col <= COLS - 4; col++) {
                if (board[row][col] != '.' && board[row][col] == board[row - 1][col + 1] && 
                    board[row][col] == board[row - 2][col + 2] && board[row][col] == board[row - 3][col + 3]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isBoardFull() {
        for (int col = 0; col < COLS; col++) {
            if (board[0][col] == '.') return false;
        }
        return true;
    }
}
