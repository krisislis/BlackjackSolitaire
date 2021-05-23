import java.util.ArrayList;

/**
 * Card class, which describes card model.
 * Every card has a its own suit and rank.
 */
public class Card {
    private Suit suit;
    private Rank rank;

    Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Return all possible point for card.
     * @return ArrayList of points.
     */
    public ArrayList<Integer> getPoints() {
        return rank.getPoints();
    }

    /**
     * Return card name.
     * @return Concat of first letter of rank and first letter of suit
     */
    public String show() {
        return rank.show() + suit.show();
    }
}
