import java.util.Collections;
import java.util.Scanner;

/**
 * BlackjackSolitaire class describes game process
 */
public class BlackjackSolitaire {
    private static String greetingMessage = "Welcome to Blackjack Solitaire Game!";

    private static String delimiter = String.join("", Collections.nCopies(75, "*"));

    private static String cardReplacementMessage(String cardName) {
        return String.format("Current card is %s; where do you want to place it? ", cardName);
    }

    private static String getFinalScoreMessage(BlackjackSolitaireTable gameTable) {
        if (gameTable == null) return null;

        int score = 0;
        for (BlackjackSolitaireLine line : gameTable.getBlackjackSolitaireLines()) {
            score += ScoreResolver.CalculateScoreForLine(line);
        }
        return String.format("Final score: %d.", score);
    }

    /**
     * This is the most important method to control the entire process of the game,
     * including communication with the player.
     */
    public static void play() {
        Deck deck = new Deck();
        deck.shuffle();
        BlackjackSolitaireTable gameTable = new BlackjackSolitaireTable();

        String cardPlaceLine;
        int cardPlace;
        Scanner in = new Scanner(System.in);

        System.out.println(greetingMessage);
        while (!gameTable.isFull()) {
            System.out.println(gameTable.show());
            System.out.println(delimiter);

            Card card = deck.nextCard();
            while (true) {
                System.out.print(cardReplacementMessage(card.show()));
                cardPlaceLine = in.nextLine();
                try {
                    cardPlace = Integer.parseInt(cardPlaceLine);
                } catch (NumberFormatException e) {
                    System.out.println("Space index must be integer!");
                    System.out.println(delimiter);
                    continue;
                }
                try {
                    gameTable.putCardToCell(card, cardPlace);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    System.out.println(delimiter);
                }
            }
        }

        System.out.println(getFinalScoreMessage(gameTable));
    }

}
