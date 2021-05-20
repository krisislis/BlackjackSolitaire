import java.util.ArrayList;

public enum Rank {
    TWO("2", "2"),
    THREE("3", "3"),
    FOUR("4", "4"),
    FIVE("5", "5"),
    SIX("6", "6"),
    SEVEN("7", "7"),
    EIGHT("8", "8"),
    NINE("9", "9"),
    TEN("10", "10"),
    JACK("J", "10"),
    QUEEN("Q", "10"),
    KING("K", "10"),
    ACE("A", "1 11");
    private String rank;
    private ArrayList<Integer> points = new ArrayList<Integer>();

    Rank(String rank, String pointsString) {
        this.rank = rank;
        this.points = new ArrayList<Integer>();
        for (String s : pointsString.split(" ")) {
            Integer point = Integer.parseInt(s);
            this.points.add(point);
        }
    }

    public String show() {
        return rank;
    }

    public ArrayList<Integer> getPoints() {
        return points;
    }

}
