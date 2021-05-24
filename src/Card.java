import java.util.List;

/**
 * Card class describes card model
 * Every Card has suit and rank
 */
public class Card {
    private Suit suit;
    private Rank rank;

    Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Returns all possible point for card
     *
     * @return ArrayList of points
     */
    public List<Integer> getPoints() {
        return rank.getPoints();
    }

    /**
     * Returns card name
     *
     * @return Concat of first letter (or number) of rank and first letter of suit
     */
    public String show() {
        return rank.show() + suit.show();
    }
}
