import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class BlackjackSolitaireLine {
    private ArrayList<Card> cards;
    private static final int threshold = 21;

    BlackjackSolitaireLine(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public int getLength() {
        return cards.size();
    }

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
