import java.util.*;

public class StandardDeck implements Deck {

   // To be used as a queue
   private final LinkedList<Card> cards;
   
   public StandardDeck() {
      cards = new LinkedList<Card>();
   }
   
   public void fill(boolean doesSuitMatter, boolean isAceHigh) {
      for (int suit = 0; suit < 4; ++suit) {
         for (int value = 1; value <= 13; ++value) {
            StandardCard card = new StandardCard(suit, value);
            card.doesSuitMatter(doesSuitMatter);
            card.isAceHigh(isAceHigh);
            cards.add(card);
         }
      }
   }
   
   public void shuffle() {
      Randomizer.shuffleList(cards);
   }
   
   public Card draw() {
      return cards.remove();
   }
   
   public void addToBottom(Card c) {
      cards.add((StandardCard) c);
   }
   
   public int size() {
      return cards.size();
   }
   
   
   
   
   public void printDeck() {
      for (Card c : cards) {
         System.out.println(c.getName());
      }
   }

}