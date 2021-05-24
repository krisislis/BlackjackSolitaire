import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BlackjackSolitaireLineTest {

    @Test(expected = IllegalArgumentException.class)
    public void testGetPointsFOrEmptyLine() {
        List<Card> cards = new ArrayList<>();
        BlackjackSolitaireLine testLine = new BlackjackSolitaireLine(cards);
        testLine.getPoints();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetPointsForLineWithNull() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.DIAMONDS, Rank.THREE));
        cards.add(null);
        BlackjackSolitaireLine testLine = new BlackjackSolitaireLine(cards);
        testLine.getPoints();
    }

    @Test
    public void testGetPointsForLineWithOneAce() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.DIAMONDS, Rank.THREE));
        cards.add(new Card(Suit.DIAMONDS, Rank.FIVE));
        cards.add(new Card(Suit.DIAMONDS, Rank.ACE));
        BlackjackSolitaireLine testLine = new BlackjackSolitaireLine(cards);
        assertEquals(19, testLine.getPoints());
    }

    @Test
    public void testGetPointsForLineWithFourAces() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.DIAMONDS, Rank.ACE));
        cards.add(new Card(Suit.CLUBS, Rank.ACE));
        cards.add(new Card(Suit.HEARTS, Rank.ACE));
        cards.add(new Card(Suit.SPADES, Rank.ACE));

        BlackjackSolitaireLine testLine = new BlackjackSolitaireLine(cards);
        assertEquals(14, testLine.getPoints());
    }

    @Test
    public void testGetPointsForLineMoreThanTwentyOne() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.DIAMONDS, Rank.TEN));
        cards.add(new Card(Suit.DIAMONDS, Rank.JACK));
        cards.add(new Card(Suit.DIAMONDS, Rank.QUEEN));
        BlackjackSolitaireLine testLine = new BlackjackSolitaireLine(cards);
        assertTrue(testLine.getPoints() > 21);
    }
}
