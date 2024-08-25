import java.util.*;

public class MemoryGame {
    private static final int SIZE = 4;
    private static char[][] board = new char[SIZE][SIZE];
    private static boolean[][] revealed = new boolean[SIZE][SIZE];
    private static List<Character> characters = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeBoard();
        shuffleBoard();

        while (!isGameWon()) {
            printBoard();
            System.out.println("Enter coordinates of the first card (row and column):");
            int row1 = scanner.nextInt();
            int col1 = scanner.nextInt();

            System.out.println("Enter coordinates of the second card (row and column):");
            int row2 = scanner.nextInt();
            int col2 = scanner.nextInt();

            if (board[row1][col1] == board[row2][col2]) {
                revealed[row1][col1] = true;
                revealed[row2][col2] = true;
                System.out.println("It's a match!");
            } else {
                System.out.println("Not a match.");
            }
        }

        System.out.println("Congratulations, you won!");
        scanner.close();
    }

    private static void initializeBoard() {
        for (char i = 'A'; i < 'A' + SIZE * SIZE / 2; i++) {
            characters.add(i);
            characters.add(i);
        }
    }

    private static void shuffleBoard() {
        Collections.shuffle(characters);
        int index = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = characters.get(index++);
            }
        }
    }

    private static void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (revealed[i][j]) {
                    System.out.print(board[i][j] + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    private static boolean isGameWon() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (!revealed[i][j]) return false;
            }
        }
        return true;
    }
}
