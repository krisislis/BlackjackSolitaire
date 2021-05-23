import java.util.Collections;
import java.util.Scanner;

/**
 * BlackjackSolitaire class describes game process.
 */
public class BlackjackSolitaire {
    private static String greetingMessage = "Welcome to Blackjack Solitaire Game!";

    private static String delimiter = String.join("", Collections.nCopies(50, "*"));

    private static String CardReplacementMessage(String cardName) {
        return String.format("Current card is %s; where do you want to place it? ", cardName);
    }

    private static String FinalScoreMessage(int score) {
        return String.format("Final score: %d.", score);
    }

    /**
     * This is the most important method to control the entire process of the game,
     * including communication with the player.
     */
    public static void play() {
        System.out.println(greetingMessage);
        Deck deck = new Deck();
        deck.shuffle();

        BlackjackSolitaireTable gameTable = new BlackjackSolitaireTable();
        Scanner in = new Scanner(System.in);

        System.out.println(gameTable.show());
        Card card = deck.nextCard();
        String cardPlaceLine;
        int cardPlace;
        boolean cardIsPlaced = false;

        while (!gameTable.isFull()) {
            System.out.println(delimiter);

            if (cardIsPlaced) {
                card = deck.nextCard();
            }
            System.out.print(CardReplacementMessage(card.show()));
            cardPlaceLine = in.nextLine();
            try {
                cardPlace = Integer.parseInt(cardPlaceLine);
            } catch (NumberFormatException e) {
                System.out.println("Space index must be integer!");
                continue;
            }
            try {
                gameTable.putCardToCell(card, cardPlace);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                cardIsPlaced = false;
                continue;
            }
            cardIsPlaced = true;
            System.out.println(gameTable.show());
        }

        int score = 0;
        for (BlackjackSolitaireLine line : gameTable.getBlackjackSolitaireLines()) {
            score += ScoreResolver.CalculateScoreForLine(line);
        }
        System.out.println(FinalScoreMessage(score));
    }

    ;
}
