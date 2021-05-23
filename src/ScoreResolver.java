/**
 * ScoreResolver class describes calculation scores for BlackjackSolitaireLine
 */
public class ScoreResolver {
    /**
     * This method returns scores for BlackjackSolitaire line
     *
     * @param line is BlackjackSolitaireLine filled with cards
     * @return score for BlackjackSolitaire line
     */
    public static int CalculateScoreForLine(BlackjackSolitaireLine line) {
        int linePoints = line.getPoints();
        int lineLength = line.getLength();
        if (linePoints == 21 & lineLength == 2) {
            return 10;
        }
        if (linePoints == 21) {
            return 7;
        }
        if (linePoints <= 20) {
            return Math.max(1, linePoints - 15);
        }
        return 0;
    }
}
