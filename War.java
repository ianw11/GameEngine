import java.util.*;

public class War extends Game {

   WarPlayer one, two;
   
   int turnNum = 0;

   public War() {
   }
   
   public void start() {
      one = new WarPlayer();
      two = new WarPlayer();
      
      StandardDeck originalDeck = new StandardDeck();
      originalDeck.fill(false, true);
      originalDeck.shuffle();
      
      GameUtils.dealDeck(originalDeck, one, two);
   }
   
   public void turn() {
      ++turnNum;
      
      WarPlayer winner = null;
      boolean winnerFound = false;
      ArrayList<StandardCard> winnersCards = new ArrayList<StandardCard>();
      
      while (!winnerFound) {
      
         StandardCard first = one.nextCard();
         StandardCard second = two.nextCard();
         
         winnersCards.add(first);
         winnersCards.add(second);
      
         int res = first.compareTo(second);
         if (res > 0) {
            System.out.println("P1 wins");
            winner = one;
            winnerFound = true;
         } else if (res < 0) {
            System.out.println("P2 wins");
            winner = two;
            winnerFound = true;
         } else {
            System.out.println("TIE");
            if (one.cardsRemaining() == 0 || two.cardsRemaining() == 0) {
               System.out.println("Somebody is out of cards for war");
               winnerFound = true;
               
               if (one.cardsRemaining() == 0) {
                  winner = two;
               } else {
                  winner = one;
               }
            }
            if (one.canAddToWar())
               winnersCards.add(one.nextCard());
            if (one.canAddToWar())
               winnersCards.add(one.nextCard());
            if (one.canAddToWar())
               winnersCards.add(one.nextCard());
            
            if (two.canAddToWar())
               winnersCards.add(two.nextCard());
            if (two.canAddToWar())
               winnersCards.add(two.nextCard());
            if (two.canAddToWar())
               winnersCards.add(two.nextCard());
         }
      
         System.out.println(turnNum + "-- " + first.getName() + " || " + second.getName());
      
      }
      
      // Needed to actually end games
      if (turnNum % 100 == 0) {
         Randomizer.shuffleList(winnersCards);
      }
      
      while (winnersCards.size() > 0) {
         winner.addCardToHand(winnersCards.remove(0));
      }
      
      System.out.println(one.cardsRemaining() + " || " + two.cardsRemaining());
      
   }
   
   
   public boolean isDone() {
      return one.didLose() || two.didLose();
   }

}