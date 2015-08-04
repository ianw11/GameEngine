public class StandardCard implements Card, Comparable<StandardCard> {

   private enum Suit {
      CLUBS, DIAMONDS, SPADES, HEARTS
   }
   
   private final Suit mSuit;
   private int mValue;
   private final String mValueStr;
   
   private boolean mDoesSuitMatter = true;
   private boolean mIsAceHigh = true;
   

   public StandardCard(int suit, int value) {
      mSuit = Suit.values()[suit];
      mValue = value;
      
      switch (mValue) {
      case 1:
      case 14:
         mValueStr = "Ace";
         break;
      case 11:
         mValueStr = "Jack";
         break;
      case 12:
         mValueStr = "Queen";
         break;
      case 13:
         mValueStr = "King";
         break;
      default:
         mValueStr = Integer.toString(mValue);
      }
   }

   /* CARD OVERRIDE METHODS */
   public String getName() {
      return mValueStr + " of " + mSuit;
   }
   
   /* COMPARABLE OVERRIDE METHOD */
   public int compareTo(StandardCard other) {
      if (mValue > other.mValue)
         return 1;
      else if (mValue < other.mValue)
         return -1;
      else if (!mDoesSuitMatter)
         return 0;
      else
         return mSuit.compareTo(other.mSuit);
   }
   
   
   /* UNIQUE METHODS */
   public void doesSuitMatter(boolean doesMatter) {
      mDoesSuitMatter = doesMatter;
   }
   
   public void isAceHigh(boolean aceHigh) {
      mIsAceHigh = aceHigh;
      if (aceHigh && mValue == 1) {
         mValue = 14;
      } else if (!aceHigh && mValue == 14) {
         mValue = 1;
      }
   }
   
}