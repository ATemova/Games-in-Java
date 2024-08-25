import java.util.Scanner;

public class SimpleMathQuiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        // Generate 5 random questions
        for (int i = 0; i < 5; i++) {
            int num1 = (int) (Math.random() * 10) + 1;
            int num2 = (int) (Math.random() * 10) + 1;
            System.out.println("What is " + num1 + " + " + num2 + "?");
            int answer = scanner.nextInt();

            if (answer == num1 + num2) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong. The correct answer was " + (num1 + num2));
            }
        }

        System.out.println("You scored: " + score + " out of 5");

        scanner.close();
    }
}
