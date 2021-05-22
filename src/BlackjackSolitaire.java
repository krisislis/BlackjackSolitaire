import java.util.Collections;
import java.util.Scanner;

public class BlackjackSolitaire {
    private static String GreetingMessage() {
        return "Welcome to Blackjack Solitaire Game!";
    }

    private static String CardReplacementMessage(String cardName) {
        return String.format("Current card is %s; where do you want to place it? ", cardName);
    }

    private static String AlreadyOccupiedMessage(String cardName) {
        return String.format("Already occupied by %s. Pick another place.", cardName);
    }

    public static void play(){
        System.out.println(GreetingMessage());
        Deck deck = new Deck();
        deck.shuffle();

        BlackjackSolitaireTable gameTable = new BlackjackSolitaireTable();
        Scanner in = new Scanner(System.in);

        do {
            System.out.println(gameTable.show());
            System.out.println(String.join("", Collections.nCopies(25, "*")));
            Card currentCard = deck.nextCard();
            System.out.println(CardReplacementMessage(currentCard.show()));
            int cardPlace = in.nextInt();
            String cardNameByIndex;
            while ((cardNameByIndex = gameTable.getCardNameByIndex(cardPlace)) != null) {
                System.out.println(AlreadyOccupiedMessage(cardNameByIndex));
                cardPlace = in.nextInt();
            }

            gameTable.putCardToCell(currentCard, cardPlace);
        } while (!gameTable.isFull());

        int score = 0;
        for (BlackjackSolitaireLine line: gameTable.getBlackjackSolitaireLines()) {
            score += ScoreResolver.CalculateScoreForLine(line);
        }
        System.out.println(score);
    };
}
