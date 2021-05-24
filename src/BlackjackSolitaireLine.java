import java.util.*;

/**
 * BlackjackSolitaireLine class describes line of cards of BlackJack solitaire game table
 */
public class BlackjackSolitaireLine {
    private final List<Card> cards;
    private static final int THRESHOLD = 21;

    BlackjackSolitaireLine(List<Card> cards) {
        this.cards = cards;
    }

    /**
     * Returns number of cards in BlackjackSolitaire line
     *
     * @return length of card line
     */
    public int getLength() {
        return cards.size();
    }

    /**
     * Calculate points in card line
     * The method calculates all possible points that can be obtained in the line
     * and choose the most profitable for the player
     *
     * @return points for BlackjackSolitaire line
     */
    public int getPoints() {
        if (cards.isEmpty()) {
            throw new IllegalArgumentException("Line must not be empty to calculate points!");
        }
        Set<Integer> previousPoints = new HashSet<>();
        Set<Integer> nextPoints = new HashSet<>();
        previousPoints.add(0);

        for (Card card : cards) {
            if (card == null) {
                throw new IllegalArgumentException("Line must be full of cards to calculate points!");
            }
            for (Integer cardPoint : card.getPoints()) {
                for (Integer point : previousPoints) {
                    nextPoints.add(cardPoint + point);
                }
            }
            previousPoints = nextPoints;
            nextPoints = new HashSet<>();
        }

        List<Integer> allPoints = new ArrayList<>();
        for (Integer point : previousPoints) {
            if (point < THRESHOLD) {
                allPoints.add(point);
            }
        }
        if (allPoints.isEmpty()) {
            return THRESHOLD + 1;
        }
        return Collections.max(allPoints);
    }
}
