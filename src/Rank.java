import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Rank enum stores ranks of playing cards
 * Every Rank has a rank name and array with all points for card with this rank
 */
public enum Rank {
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    JACK("J", 10),
    QUEEN("Q", 10),
    KING("K", 10),
    ACE("A", 1, 11);
    private String rank;
    private List<Integer> points;

    Rank(String rank, Integer... points) {
        this.rank = rank;
        this.points = Arrays.asList(points);
    }

    /**
     * Returns rank name
     *
     * @return First letter for non-number ranks, otherwise number
     */
    public String show() {
        return rank;
    }

    /**
     * Returns points for card rank
     *
     * @return ArrayList of all possible points for card rank
     */
    public List<Integer> getPoints() {
        return points;
    }

}
