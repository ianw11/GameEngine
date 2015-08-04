import java.util.ArrayList;

public class Game {

   public static void main(String[] args) {
      for (int i = 0; i < 1; ++i) {
         new Game().run();
         System.out.println("GAME " + i + " COMPLETE\n");
      }
   }
   
   public void run() {
      Format game = new Poker();
      game.start();
      
      while (!game.isDone()) {
         game.turn();
      }
   }

}