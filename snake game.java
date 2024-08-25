import java.util.Random;
import java.util.Scanner;

public class SimpleSnakeGame {
    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;
    private static char[][] board = new char[HEIGHT][WIDTH];
    private static int[] snakeHead = {HEIGHT / 2, WIDTH / 2};
    private static int[] food = new int[2];
    private static char direction = 'R';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        placeFood(random);

        while (true) {
            printBoard();
            System.out.println("Enter direction (W/A/S/D):");
            char input = scanner.next().toUpperCase().charAt(0);
            switch (input) {
                case 'W': direction = 'U'; break;
                case 'A': direction = 'L'; break;
                case 'S': direction = 'D'; break;
                case 'D': direction = 'R'; break;
                default: System.out.println("Invalid input. Use W/A/S/D."); continue;
            }

            moveSnake();
            if (snakeHead[0] == food[0] && snakeHead[1] == food[1]) {
                System.out.println("Food eaten!");
                placeFood(random);
            }
        }
    }

    private static void printBoard() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (i == snakeHead[0] && j == snakeHead[1]) {
                    System.out.print("S ");
                } else if (i == food[0] && j == food[1]) {
                    System.out.print("F ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    private static void moveSnake() {
        switch (direction) {
            case 'U': snakeHead[0]--; break;
            case 'D': snakeHead[0]++; break;
            case 'L': snakeHead[1]--; break;
            case 'R': snakeHead[1]++; break;
        }

        if (snakeHead[0] < 0 || snakeHead[0] >= HEIGHT || snakeHead[1] < 0 || snakeHead[1] >= WIDTH) {
            System.out.println("Game Over!");
            System.exit(0);
        }
    }

    private static void placeFood(Random random) {
        food[0] = random.nextInt(HEIGHT);
        food[1] = random.nextInt(WIDTH);
    }
}
