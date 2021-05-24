import java.util.ArrayList;
import java.util.List;

/**
 * BlackjackSolitaireTable class describes BlackjackSolitaire game table
 * It has 20 card cells, 16 of them are for active cards and other cells are for discard cards
 */
public class BlackjackSolitaireTable {
    private Card[] cells = new Card[20];
    private static final int activeCellsSize = 16;
    private int[][] allLinesIndexes = {
            {0, 1, 2, 3, 4},
            {5, 6, 7, 8, 9},
            {10, 11, 12},
            {13, 14, 15},
            {0, 5},
            {1, 6, 10, 13},
            {2, 7, 11, 14},
            {3, 8, 12, 15},
            {4, 9},
    };
    private String blackjackSolitaireTableView =
            "%s\t\t%s\t\t%s\t\t%s\t\t%s\n" +
                    "%s\t\t%s\t\t%s\t\t%s\t\t%s\n" +
                    "   \t\t%s\t\t%s\t\t%s\n" +
                    "   \t\t%s\t\t%s\t\t%s\n";

    private int getNumberOfFreeDiscardCells() {
        int numberOfFreeDiscardCells = 0;
        for (int i = activeCellsSize; i < cells.length; i++) {
            if (cells[i] == null) {
                numberOfFreeDiscardCells++;
            }
        }
        return numberOfFreeDiscardCells;
    }

    private List<Card> createArrayListFromCellsIndexes(int[] indexes) {
        List<Card> cardArrayList = new ArrayList<Card>();
        for (int i : indexes) {
            cardArrayList.add(cells[i]);
        }
        return cardArrayList;
    }

    private String getCardNameByIndex(int cardIndex) {
        return cells[cardIndex] == null ? null : cells[cardIndex].show();
    }

    /**
     * Check if there are free cells for cards
     *
     * @return true if there are free cells, otherwise false
     */
    public boolean isFull() {
        for (int i = 0; i < activeCellsSize; i++) {
            if (cells[i] == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Allow to put a card in a cell of the game table
     *
     * @param card      Card object to pull in cell
     * @param cellIndex Number of cell on a game table
     * @throws IllegalArgumentException if out-of-bound cell index or cell has already been filled
     */
    public void putCardToCell(Card card, int cellIndex) throws IllegalArgumentException {
        cellIndex--;
        String cardNameByIndex;

        if (cellIndex >= cells.length) {
            throw new IllegalArgumentException("Place index can not be more than 20!");
        }
        if (cellIndex < 0) {
            throw new IllegalArgumentException("Place index can not be less than 1!");
        }
        if ((cardNameByIndex = getCardNameByIndex(cellIndex)) != null) {
            throw new IllegalArgumentException(
                    String.format("Already occupied by %s. Pick another place.", cardNameByIndex)
            );
        }
        cells[cellIndex] = card;
    }

    /**
     * Return all possible BlackJackSolitaire lines of game table, when game is over.
     *
     * @return all BlackJackSolitaire lines
     */
    public BlackjackSolitaireLine[] getBlackjackSolitaireLines() {
        if (!isFull()) {
            return null;
        }

        BlackjackSolitaireLine[] blackjackSolitaireLines = new BlackjackSolitaireLine[allLinesIndexes.length];
        for (int i = 0; i < allLinesIndexes.length; i++) {
            blackjackSolitaireLines[i] = new BlackjackSolitaireLine(
                    createArrayListFromCellsIndexes(allLinesIndexes[i])
            );
        }
        return blackjackSolitaireLines;
    }

    /**
     * Return formatted view of game table
     *
     * @return String with view of BlackjackSolitaireTable
     */
    public String show() {
        String[] currentCellValues = new String[activeCellsSize];
        for (int i = 0; i < activeCellsSize; i++) {
            currentCellValues[i] = cells[i] == null ? String.valueOf(i + 1) : cells[i].show();
        }

        String discardCellsMessage = String.format("Free slots on discard pile: %d", getNumberOfFreeDiscardCells());
        return String.format(blackjackSolitaireTableView, currentCellValues) + discardCellsMessage;  // TODO IDE ругается на то, что currentCellValues не Object
    }
}
