import java.util.ArrayList;

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
                    "   \t\t%s\t\t%s\t\t%s\t\t\n" +
                    "   \t\t%s\t\t%s\t\t%s\t\t\n";

    private int getNumberOfFreeDiscardCells() {
        int numberOfFreeDiscardCells = 4;
        for (int i = activeCellsSize; i < cells.length; i++) {
            if (cells[i] != null) {
                numberOfFreeDiscardCells--;
            }
        }
        return numberOfFreeDiscardCells;
    }

    public boolean isFull() {
        for (int i = 0; i < activeCellsSize; i++) {
            if (cells[i] == null) {
                return false;
            }
        }
        return true;
    }

    public void putCardToCell(Card card, int cellIndex) {
        if (cellIndex >= cells.length) {
            throw new ArrayIndexOutOfBoundsException(cells.length);
        }
        if (cellIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(-1);
        }
        if (cells[cellIndex] != null) {
            System.out.println("You are idiot");
        }
        cells[cellIndex - 1] = card;
    }

    private ArrayList<Card> createArrayListFromCellsIndexes(int[] indexes) {
        ArrayList<Card> cardArrayList = new ArrayList<>();
        for (int i : indexes) {
            cardArrayList.add(cells[i]);
        }
        return cardArrayList;
    }

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

    public String show() {

        String[] currentCellValues = new String[activeCellsSize];
        for (int i = 0; i < activeCellsSize; i++) {
            currentCellValues[i] = cells[i] == null ? String.valueOf(i + 1) : cells[i].show();
        }

        String discardCellsMessage = String.format("Free slots on discard pile: %d", getNumberOfFreeDiscardCells());
        return String.format(blackjackSolitaireTableView, currentCellValues) + discardCellsMessage;  // TODO IDE ругается на то, что currentCellValues не Object
    }
}
