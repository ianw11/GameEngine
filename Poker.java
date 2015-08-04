public class Poker extends Game {

   PokerPlayer one;

   public void start() {
      one = new PokerPlayer();
   }
   
   public void turn() {
   
   }
   
   public boolean isDone() {
      return true;
   }

}