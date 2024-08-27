import java.util.*;

public class MazeSolver {
    private static final int[][] MAZE = {
        {1, 0, 0, 0, 0},
        {1, 1, 0, 1, 1},
        0, 1, 1, 1, 0,
        1, 1, 0, 0, 0,
        1, 1, 1, 1, 1
    };
    private static final int[] START = {0, 0};
    private static final int[] END = {4, 4};
    private static final int ROWS = 5;
    private static final int COLS = 5;

    public static void main(String[] args) {
        boolean[][] visited = new boolean[ROWS][COLS];
        if (findPath(START[0], START[1], visited)) {
            System.out.println("Path found!");
        } else {
            System.out.println("No path found.");
        }
    }

    private static boolean findPath(int x, int y, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= ROWS || y >= COLS || MAZE[x][y] == 0 || visited[x][y]) return false;
        visited[x][y] = true;
        if (x == END[0] && y == END[1]) return true;

        if (findPath(x + 1, y, visited) || findPath(x, y + 1, visited) ||
            findPath(x - 1, y, visited) || findPath(x, y - 1, visited)) return true;

        return false;
    }
}
