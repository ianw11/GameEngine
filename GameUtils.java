public class GameUtils {

   public static void dealDeck(Deck d, Player... players) {
      int numPlayers = players.length;
      int currPlayer = 0;
      
      while (d.size() > 0) {
         players[currPlayer++].addCardToHand(d.draw());
         
         if (currPlayer == numPlayers)
            currPlayer = 0;
      }
   }
   
   public static void dealDeckN(Deck d, int n, Player... players) {
      int numPlayers = players.length;
      int currPlayer = 0;
      
      int i = n;
      
      while (i > 0) {
         players[currPlayer++].addCardToHand(d.draw());
         
         if (currPlayer == numPlayers)
            currPlayer = 0;
         
         --i;
      }
   }

}