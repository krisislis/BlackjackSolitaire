/**
 * Suit enum stores suits of playing cards
 */
public enum Suit {
    DIAMONDS("D"),
    CLUBS("C"),
    HEARTS("H"),
    SPADES("S");

    private String shortName;

    Suit(String shortName) {
        this.shortName = shortName;
    }

    /**
     * Return card suit as first letter of suit name
     *
     * @return First letter of suit name
     */
    public String show() {
        return shortName;
    }
}
