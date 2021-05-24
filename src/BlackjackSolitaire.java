import java.util.Collections;
import java.util.Scanner;

/**
 * BlackjackSolitaire class describes game process
 */
public class BlackjackSolitaire {
    private static final String GREETING_MESSAGE = "Welcome to Blackjack Solitaire Game!";

    private static final String DELIMITER = String.join("", Collections.nCopies(75, "*"));

    private static String cardReplacementMessage(String cardName) {
        return String.format("Current card is %s; where do you want to place it? ", cardName);
    }

    private static String getFinalScoreMessage(BlackjackSolitaireTable gameTable) {
        if (gameTable == null) return null;

        int score = 0;
        for (BlackjackSolitaireLine line : gameTable.getBlackjackSolitaireLines()) {
            score += ScoreResolver.calculateScoreForLine(line);
        }
        return String.format("Final score: %d.", score);
    }

    /**
     * This is the most important method to control the entire process of the game,
     * including communication with the player.
     */
    public void play() {
        Deck deck = Deck.getShuffledDeck();
        BlackjackSolitaireTable gameTable = new BlackjackSolitaireTable();

        String cardPlaceLine;
        int cardPlace;
        Scanner in = new Scanner(System.in);

        System.out.println(GREETING_MESSAGE);
        while (!gameTable.isFull()) {
            System.out.println(gameTable.show());
            System.out.println(DELIMITER);

            Card card = deck.nextCard();
            while (true) {
                System.out.print(cardReplacementMessage(card.show()));
                cardPlaceLine = in.nextLine();
                try {
                    cardPlace = Integer.parseInt(cardPlaceLine);
                } catch (NumberFormatException e) {
                    System.out.println("Space index must be integer!");
                    System.out.println(DELIMITER);
                    continue;
                }
                try {
                    gameTable.putCardToCell(card, cardPlace);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    System.out.println(DELIMITER);
                }
            }
        }

        System.out.println(getFinalScoreMessage(gameTable));
    }

}
