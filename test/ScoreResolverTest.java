import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ScoreResolverTest {

    @Test
    public void testBlackjack() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.DIAMONDS, Rank.QUEEN));
        cards.add(new Card(Suit.CLUBS, Rank.ACE));
        BlackjackSolitaireLine testLine = new BlackjackSolitaireLine(cards);
        assertEquals(10, ScoreResolver.calculateScoreForLine(testLine));
    }

    @Test
    public void testSevenScore() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.DIAMONDS, Rank.QUEEN));
        cards.add(new Card(Suit.CLUBS, Rank.ACE));
        cards.add(new Card(Suit.HEARTS, Rank.QUEEN));
        BlackjackSolitaireLine testLine = new BlackjackSolitaireLine(cards);
        assertEquals(7, ScoreResolver.calculateScoreForLine(testLine));
    }

    @Test
    public void testOneScore() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.DIAMONDS, Rank.THREE));
        cards.add(new Card(Suit.CLUBS, Rank.TEN));
        BlackjackSolitaireLine testLine = new BlackjackSolitaireLine(cards);
        assertEquals(1, ScoreResolver.calculateScoreForLine(testLine));
    }

    @Test
    public void testZeroScore() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.DIAMONDS, Rank.QUEEN));
        cards.add(new Card(Suit.CLUBS, Rank.JACK));
        cards.add(new Card(Suit.HEARTS, Rank.KING));
        BlackjackSolitaireLine testLine = new BlackjackSolitaireLine(cards);
        assertEquals(0, ScoreResolver.calculateScoreForLine(testLine));
    }

    @Test
    public void testAllCellsFortyOne() {
        /*
        This test is not unit test.
         */
        BlackjackSolitaireTable testGameTable = new BlackjackSolitaireTable();
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.QUEEN), 1);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.TWO), 2);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.THREE), 3);
        testGameTable.putCardToCell(new Card(Suit.SPADES, Rank.JACK), 4);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.ACE), 5);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.ACE), 6);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.FOUR), 7);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.KING), 8);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.SEVEN), 9);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.JACK), 10);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.SIX), 11);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.SEVEN), 12);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.EIGHT), 13);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.NINE), 14);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.NINE), 15);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.THREE), 16);

        int score = 0;
        for (BlackjackSolitaireLine line : testGameTable.getBlackjackSolitaireLines()) {
            score += ScoreResolver.calculateScoreForLine(line);
        }
        assertEquals(41, score);
    }

    @Test
    public void testAllCellsTwentyFourWithDiscards() {
        /*
        This test is not unit test.
         */
        BlackjackSolitaireTable testGameTable = new BlackjackSolitaireTable();
        testGameTable.putCardToCell(new Card(Suit.SPADES, Rank.JACK), 1);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.NINE), 2);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.THREE), 3);
        testGameTable.putCardToCell(new Card(Suit.SPADES, Rank.FIVE), 4);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.JACK), 5);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.ACE), 6);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.NINE), 7);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.FOUR), 8);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.SIX), 9);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.SIX), 10);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.THREE), 11);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.EIGHT), 12);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.EIGHT), 13);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.TWO), 14);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.THREE), 15);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.ACE), 16);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.NINE), 17);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.SEVEN), 18);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.FIVE), 19);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.JACK), 20);


        int score = 0;
        for (BlackjackSolitaireLine line : testGameTable.getBlackjackSolitaireLines()) {
            score += ScoreResolver.calculateScoreForLine(line);
        }
        assertEquals(24, score);
    }

    @Test
    public void testAllCellsFortyTwo() {
        /*
        This test is not unit test.
         */
        BlackjackSolitaireTable testGameTable = new BlackjackSolitaireTable();
        testGameTable.putCardToCell(new Card(Suit.SPADES, Rank.ACE), 1);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.NINE), 2);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.FOUR), 3);
        testGameTable.putCardToCell(new Card(Suit.SPADES, Rank.THREE), 4);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.TEN), 5);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.JACK), 6);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.SIX), 7);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.FIVE), 8);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.FOUR), 9);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.ACE), 10);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.JACK), 11);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.TWO), 12);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.SIX), 13);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.FOUR), 14);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.QUEEN), 15);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.SEVEN), 16);

        int score = 0;
        for (BlackjackSolitaireLine line : testGameTable.getBlackjackSolitaireLines()) {
            score += ScoreResolver.calculateScoreForLine(line);
        }
        assertEquals(42, score);
    }

    @Test
    public void testAllCellsSixtySevenWithDiscards() {
        /*
        This test is not unit test.
         */
        BlackjackSolitaireTable testGameTable = new BlackjackSolitaireTable();
        testGameTable.putCardToCell(new Card(Suit.SPADES, Rank.TEN), 1);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.TWO), 2);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.FIVE), 3);
        testGameTable.putCardToCell(new Card(Suit.SPADES, Rank.THREE), 4);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.ACE), 5);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.ACE), 6);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.FOUR), 7);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.FOUR), 8);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.TWO), 9);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.TEN), 10);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.FIVE), 11);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.NINE), 12);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.SEVEN), 13);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.JACK), 14);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.THREE), 15);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.EIGHT), 16);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.EIGHT), 17);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.SIX), 18);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.NINE), 19);

        int score = 0;
        for (BlackjackSolitaireLine line : testGameTable.getBlackjackSolitaireLines()) {
            score += ScoreResolver.calculateScoreForLine(line);
        }
        assertEquals(67, score);
    }

    @Test
    public void testAllCellsTwelveWithDiscards() {
        /*
        This test is not unit test.
         */
        BlackjackSolitaireTable testGameTable = new BlackjackSolitaireTable();
        testGameTable.putCardToCell(new Card(Suit.SPADES, Rank.JACK), 1);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.FIVE), 2);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.KING), 3);
        testGameTable.putCardToCell(new Card(Suit.SPADES, Rank.QUEEN), 4);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.NINE), 5);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.JACK), 6);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.TWO), 7);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.FOUR), 8);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.TWO), 9);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.QUEEN), 10);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.FOUR), 11);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.KING), 12);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.TEN), 13);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.ACE), 14);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.EIGHT), 15);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.EIGHT), 16);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.KING), 17);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.QUEEN), 18);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.FOUR), 19);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.THREE), 20);


        int score = 0;
        for (BlackjackSolitaireLine line : testGameTable.getBlackjackSolitaireLines()) {
            score += ScoreResolver.calculateScoreForLine(line);
        }
        assertEquals(12, score);
    }

    @Test
    public void testAllCellsTwentySixWithDiscards() {
        /*
        This test is not unit test.
         */
        BlackjackSolitaireTable testGameTable = new BlackjackSolitaireTable();
        testGameTable.putCardToCell(new Card(Suit.SPADES, Rank.TEN), 1);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.SEVEN), 2);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.SEVEN), 3);
        testGameTable.putCardToCell(new Card(Suit.SPADES, Rank.SIX), 4);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.QUEEN), 5);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.ACE), 6);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.NINE), 7);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.FOUR), 8);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.TWO), 9);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.QUEEN), 10);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.KING), 11);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.KING), 12);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.FOUR), 13);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.FIVE), 14);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.FIVE), 15);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.NINE), 16);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.FOUR), 17);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.FIVE), 18);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.THREE), 19);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.SIX), 20);


        int score = 0;
        for (BlackjackSolitaireLine line : testGameTable.getBlackjackSolitaireLines()) {
            score += ScoreResolver.calculateScoreForLine(line);
        }
        assertEquals(26, score);
    }

    @Test
    public void testAllCellsFortyOneWithDiscards() {
        /*
        This test is not unit test.
         */
        BlackjackSolitaireTable testGameTable = new BlackjackSolitaireTable();
        testGameTable.putCardToCell(new Card(Suit.SPADES, Rank.QUEEN), 1);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.TWO), 2);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.THREE), 3);
        testGameTable.putCardToCell(new Card(Suit.SPADES, Rank.QUEEN), 4);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.ACE), 5);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.ACE), 6);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.FOUR), 7);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.KING), 8);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.SEVEN), 9);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.JACK), 10);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.SIX), 11);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.SEVEN), 12);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.EIGHT), 13);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.NINE), 14);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.NINE), 15);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.THREE), 16);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.FOUR), 17);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.SEVEN), 18);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.EIGHT), 19);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.SIX), 20);


        int score = 0;
        for (BlackjackSolitaireLine line : testGameTable.getBlackjackSolitaireLines()) {
            score += ScoreResolver.calculateScoreForLine(line);
        }
        assertEquals(41, score);
    }

    @Test
    public void testAllCellsThirty() {
        /*
        This test is not unit test.
         */
        BlackjackSolitaireTable testGameTable = new BlackjackSolitaireTable();
        testGameTable.putCardToCell(new Card(Suit.SPADES, Rank.KING), 1);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.NINE), 2);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.EIGHT), 3);
        testGameTable.putCardToCell(new Card(Suit.SPADES, Rank.SIX), 4);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.ACE), 5);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.ACE), 6);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.FOUR), 7);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.NINE), 8);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.SIX), 9);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.JACK), 10);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.SIX), 11);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.FOUR), 12);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.QUEEN), 13);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.EIGHT), 14);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.NINE), 15);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.THREE), 16);

        int score = 0;
        for (BlackjackSolitaireLine line : testGameTable.getBlackjackSolitaireLines()) {
            score += ScoreResolver.calculateScoreForLine(line);
        }
        assertEquals(30, score);
    }

    @Test
    public void testAllCellsTwentyFour() {
        /*
        This test is not unit test.
         */
        BlackjackSolitaireTable testGameTable = new BlackjackSolitaireTable();
        testGameTable.putCardToCell(new Card(Suit.SPADES, Rank.QUEEN), 1);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.FIVE), 2);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.THREE), 3);
        testGameTable.putCardToCell(new Card(Suit.SPADES, Rank.TWO), 4);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.TEN), 5);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.EIGHT), 6);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.EIGHT), 7);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.SIX), 8);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.TEN), 9);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.KING), 10);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.FOUR), 11);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.FIVE), 12);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.EIGHT), 13);

        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.QUEEN), 14);
        testGameTable.putCardToCell(new Card(Suit.CLUBS, Rank.JACK), 15);
        testGameTable.putCardToCell(new Card(Suit.HEARTS, Rank.ACE), 16);

        int score = 0;
        for (BlackjackSolitaireLine line : testGameTable.getBlackjackSolitaireLines()) {
            score += ScoreResolver.calculateScoreForLine(line);
        }
        assertEquals(24, score);
    }

}
