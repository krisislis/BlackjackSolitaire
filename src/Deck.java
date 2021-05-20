import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;
    private int currentCardIndex;

    Deck() {
        this.currentCardIndex = 0;
        this.cards = new ArrayList<Card>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(suit, rank);
                this.cards.add(card);
            }
        }
    }

    // TODO
    public Card nextCard() {
        if (currentCardIndex == cards.size() - 1) {
            return null;
        }
        return cards.get(currentCardIndex++);
    }

    // TODO
    public void shuffle() {
        if (currentCardIndex == 0) {
            Collections.shuffle(cards);
        }
    }

}
