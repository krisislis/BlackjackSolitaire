/**
 * ScoreResolver class describes calculation scores for BlackjackSolitaireLine
 */
public class ScoreResolver {
    /**
     * This method returns scores for BlackjackSolitaire line
     * @param blackjackSolitaireLine get BlackjackSolitaire line from game table
     * @return score for BlackjackSolitaire line
     */
    public static int CalculateScoreForLine(BlackjackSolitaireLine blackjackSolitaireLine) {
        int linePoints = blackjackSolitaireLine.getPoints();
        int lineLength = blackjackSolitaireLine.getLength();
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
