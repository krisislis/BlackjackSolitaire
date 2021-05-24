import java.util.*;

/**
 * BlackjackSolitaireLine class describes line of cards of BlackJack solitaire game table
 */
public class BlackjackSolitaireLine {
    private List<Card> cards;
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
        Set<Integer> previousPoints = new HashSet<Integer>();
        Set<Integer> nextPoints = new HashSet<Integer>();
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
