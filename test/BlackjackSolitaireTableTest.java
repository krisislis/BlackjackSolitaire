import org.junit.Test;

public class BlackjackSolitaireTableTest {

    BlackjackSolitaireTable instance;

    public BlackjackSolitaireTableTest() {
        instance = new BlackjackSolitaireTable();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutCardToZeroCellIndex() {
        Card validCard = new Card(Suit.DIAMONDS, Rank.THREE);
        instance.putCardToCell(validCard, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutCardToNegativeCellIndex() {
        Card validCard = new Card(Suit.DIAMONDS, Rank.THREE);
        instance.putCardToCell(validCard, -11);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutCardToOutOfRangeIndexCell() {
        Card validCard = new Card(Suit.DIAMONDS, Rank.THREE);
        instance.putCardToCell(validCard, 21);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutNullToCell() {
        instance.putCardToCell(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutCardToOneCellTwice() {
        Card firstCard = new Card(Suit.DIAMONDS, Rank.FIVE);
        Card secondCard = new Card(Suit.DIAMONDS, Rank.SEVEN);

        instance.putCardToCell(firstCard, 1);
        instance.putCardToCell(secondCard, 1);
    }

}
