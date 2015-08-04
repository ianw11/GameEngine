public interface Deck {
   
   public void shuffle();
   public Card draw();
   public void addToBottom(Card c);
   
   
   public int size();
   
   public void printDeck();
   
}