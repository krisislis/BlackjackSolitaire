import java.util.ArrayList;

public class Card {
    private Suit suit;
    private Rank rank;

    Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public ArrayList<Integer> getPoints() {
        return rank.getPoints();
    }

    public String show() {
        return rank.show() + suit.show();
    }
}
