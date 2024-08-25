import java.util.*;

public class SimpleWarGame {
    public static void main(String[] args) {
        List<Integer> deck = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            deck.add(i);
        }

        // Shuffle the deck
        Collections.shuffle(deck);

        // Player 1 and Player 2 draw cards
        int player1Card = deck.remove(0);
        int player2Card = deck.remove(0);

        System.out.println("Player 1 draws: " + player1Card);
        System.out.println("Player 2 draws: " + player2Card);

        // Determine the winner
        if (player1Card > player2Card) {
            System.out.println("Player 1 wins!");
        } else if (player2Card > player1Card) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
