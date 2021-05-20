public class Test {
    public static void main(String[] args) {
//        System.out.println(Suit.CLUBS.show());
//        System.out.println(Rank.ACE.getPoints());
//        System.out.println(Rank.ACE.show());
//
//        System.out.println(Rank.THREE.getPoints());
//        System.out.println(Rank.THREE.show());

        Deck deck = new Deck();
        System.out.println(deck);
        deck.shuffle();
        System.out.println(deck.nextCard().show());

    }
}
