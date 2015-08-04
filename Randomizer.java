import java.util.*;

public class Randomizer {

   static Random rnd = new Random();

   public static void shuffleArray(int[] ar) {
      for (int i = ar.length - 1; i > 0; i--) {
         int index = rnd.nextInt(i + 1);
         // Simple swap
         int a = ar[index];
         ar[index] = ar[i];
         ar[i] = a;
      }
   }
   
   public static <T> void shuffleList(List<T> arr) {
      for (int i = arr.size() - 1; i > 0; --i) {
         int index = rnd.nextInt(i);
                  
         T val = arr.remove(index);
         
         T other = arr.remove(i - 1);
         arr.add(index, other);
         
         arr.add(i, val);
      }
   }
   
   
   public static void main(String[] args) {
      ArrayList<Integer> arr = new ArrayList<Integer>();
      arr.add(0);
      arr.add(1);
      arr.add(2);
      arr.add(3);
      arr.add(4);
      arr.add(5);
      arr.add(6);
      arr.add(7);
      arr.add(8);
      arr.add(9);
      
      Randomizer.shuffleList(arr);
      
      for (Integer i : arr) {
         System.out.println(i);
      }
   }
   
}