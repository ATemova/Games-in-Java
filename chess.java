public class ChessGame {
    private static final char EMPTY = '.';
    private static final char[][] board = new char[8][8];

    public static void main(String[] args) {
        initializeBoard();
        printBoard();
        // Implement game logic
    }

    private static void initializeBoard() {
        String[] initialRow = {"R", "N", "B", "Q", "K", "B", "N", "R"};
        for (int i = 0; i < 8; i++) {
            board[0][i] = initialRow[i].charAt(0);
            board[1][i] = 'P';
            board[6][i] = 'p';
            board[7][i] = initialRow[i].toLowerCase().charAt(0);
        }
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    private static void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
