/**
 * All available Card suits
 */

public enum Suit {
    /**
     * Diamonds suit
     */
    DIAMONDS("D"),
    /**
     * Clubs suit
     */
    CLUBS("C"),
    /**
     * Hearts suit
     */
    HEARTS("H"),
    /**
     * Spades suit
     */
    SPADES("S");

    private String shortName;

    Suit(String shortName){
        this.shortName = shortName;
    }

    /**
     * Return card suit as first letter of suit name
     * @return First letter of suit name
     */
    public String show(){
        return shortName;
    }
}
