import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
//        System.out.println(Suit.CLUBS.show());
//        System.out.println(Rank.ACE.getPoints());
//        System.out.println(Rank.ACE.show());
//        Deck deck = new Deck();
//        System.out.println(deck);
//        deck.shuffle();
//        Card card0 = deck.nextCard();
//        System.out.println(card0.show());
//        Card card1 = deck.nextCard();
//        System.out.println(card1.show());
//        ArrayList<Card> cardLine = new ArrayList<Card>();
//        cardLine.add(card1);
//        cardLine.add(card0);
//        BlackjackSolitaireLine line = new BlackjackSolitaireLine(cardLine);
        String[] arr;
        arr = new String[]{"1", "10D", "3", "4", "5"};
        String s = String.format("%s\t\t%s\t\t%s\t\t%s\t\t%s", arr);
        System.out.println(s);

    }
}
