public enum Suit {
    DIAMONDS("D"),
    CLUBS("C"),
    HEARTS("H"),
    SPADES("S");

    private String shortName;

    Suit(String shortName){
        this.shortName = shortName;
    }
    public String show(){
        return shortName;
    }
}
