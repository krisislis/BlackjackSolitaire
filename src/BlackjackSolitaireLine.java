import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * BlackjackSolitaireLine class describes line of cards of BlackJackSolitaire game table.
 */
public class BlackjackSolitaireLine {
    private ArrayList<Card> cards;
    private static final int threshold = 21;

    BlackjackSolitaireLine(ArrayList<Card> cards) {
        this.cards = cards;
    }

    /**
     * This method is used to get number of cards in BlackjackSolitaire line.
     * @return length of card line
     */
    public int getLength() {
        return cards.size();
    }

    /**
     * This method is used to calculate point in card line.
     * The method calculates all possible points that can be obtained in the line
     * and choose the most profitable for the player.
     * @return point for BlackjackSolitaire line
     */
    public int getPoints() {
        HashSet<Integer> previousPoints = new HashSet<>();
        HashSet<Integer> nextPoints = new HashSet<>();
        previousPoints.add(0);

        for (Card card : cards) {
            for (Integer cardPoint : card.getPoints()) {
                for (Integer point : previousPoints) {
                    nextPoints.add(cardPoint + point);
                }
            }
            previousPoints = nextPoints;
            nextPoints = new HashSet<Integer>();
        }

        ArrayList<Integer> allPoints = new ArrayList<>();
        for (Integer point : previousPoints) {
            if (point < threshold) {
                allPoints.add(point);
            }
        }
        if (allPoints.isEmpty()) {
            return threshold + 1;
        }
        return Collections.max(allPoints);
    }
}
