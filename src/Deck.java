import java.util.ArrayList;
import java.util.Collections;

/**
 * Card Deck class, which describes the playing deck model.
 */
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

    /**
     * Iteratively returns cards from the deck.
     * @return Card from the deck.
     */
    public Card nextCard() {
        // TODO
        if (currentCardIndex == cards.size() - 1) {
            return null;
        }
        return cards.get(currentCardIndex++);
    }

    /**
     * Shuffle the deck if game hasn't been started.
     */
    public void shuffle() {
        // TODO
        if (currentCardIndex == 0) {
            Collections.shuffle(cards);
        }
    }

}
