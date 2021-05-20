import java.util.ArrayList;

public class Card {
    private Suit suit;
    private Rank rank;

    public ArrayList<Integer> getPoints() {
        return rank.getPoints();
    }

    public String show() {
        return suit.show() + rank.show();
    }
}
