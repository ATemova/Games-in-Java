public class AdvancedGameOfLife {
    private static final int SIZE = 20;
    private static boolean[][] board = new boolean[SIZE][SIZE];
    private static boolean[][] newBoard = new boolean[SIZE][SIZE];

    public static void main(String[] args) {
        initializeBoard();
        for (int i = 0; i < 10; i++) {
            printBoard();
            updateBoard();
            try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }

    private static void initializeBoard() {
        board[10][10] = board[10][11] = board[10][12] = board[11][11] = board[12][11] = true;
    }

    private static void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] ? "*" : " ");
            }
            System.out.println();
        }
    }

    private static void updateBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int aliveNeighbors = countAliveNeighbors(i, j);
                newBoard[i][j] = (board[i][j] && (aliveNeighbors == 2 || aliveNeighbors == 3)) ||
                                 (!board[i][j] && aliveNeighbors == 3);
            }
        }
        boolean[][] temp = board;
        board = newBoard;
        newBoard = temp;
    }

    private static int countAliveNeighbors(int x, int y) {
        int count = 0;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue;
                int nx = x + dx, ny = y + dy;
                if (nx >= 0 && nx < SIZE && ny >= 0 && ny < SIZE && board[nx][ny]) count++;
            }
        }
        return count;
    }
}
