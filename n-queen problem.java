public class NQueens {
    private static final int N = 8;
    private static int[] board = new int[N];

    public static void main(String[] args) {
        solveNQueens(0);
    }

    private static boolean solveNQueens(int row) {
        if (row == N) {
            printBoard();
            return true;
        }
        boolean result = false;
        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                board[row] = col;
                result = solveNQueens(row + 1) || result;
            }
        }
        return result;
    }

    private static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    private static void printBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i] == j ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
