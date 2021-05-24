import java.util.*;

/**
 * Card Deck class describes the playing deck model
 */
public class Deck {
    private List<Card> cards;
    private int currentCardIndex;

    Deck() {
        this.currentCardIndex = 0;
        this.cards = new ArrayList<Card>(Suit.values().length * Rank.values().length);
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(suit, rank);
                this.cards.add(card);
            }
        }
    }

    /**
     * Return next card from the deck
     *
     * @return Card from the deck.
     */
    public Card nextCard() {
        if (currentCardIndex == cards.size()) {
            return null;
        }
        return cards.get(currentCardIndex++);
    }

    /**
     * Shuffles the deck if no cards have been drawn yet
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

}
