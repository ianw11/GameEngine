import java.util.ArrayList;

public class Engine {

   public static void main(String[] args) {
      for (int i = 0; i < 1; ++i) {
         new Engine().run();
         System.out.println("GAME " + i + " COMPLETE\n");
      }
   }
   
   public void run() {
      Game game = new Poker();
      game.start();
      while (!game.isDone()) {
         game.turn();
      }
   }

}