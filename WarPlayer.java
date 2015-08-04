public class WarPlayer extends Player {

   private final StandardDeck hand;
   
   public WarPlayer() {
      hand = new StandardDeck();
   }
   
   /* PLAYER OVERRIDE METHODS */
   public void addCardToHand(Card c) {
      hand.addToBottom((StandardCard) c);
   }
   
   public boolean didLose() {
      return hand.size() == 0;
   }
   
   
   /* UNIQUE METHODS */
   
   public StandardCard nextCard() {
      return (StandardCard) hand.draw();
   }
   
   public boolean canAddToWar() {
      return hand.size() > 1;
   }
   
   public int cardsRemaining() {
      return hand.size();
   }

}