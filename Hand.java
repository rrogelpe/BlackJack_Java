package blackjack;
/* File name : Hand.java */

/**
 * This class represents a hand in a game of Blackjack.
 * Instances of the 'Card' class can be added to an
 * instance of this class. Methods can be invoked to 
 * calculate the comulative sum of card values and to
 * display the cards in the hand.
 *
 * @author Rodrigo Rogel-Perez
 * @version 1.0
**/

public class Hand {

   /**
    * Constructor with complete initialization.
    * A hand can hold 11 cards at max. 
    *
   **/
   public Hand () {
      this.hand = new Card[21];
      this.handValue = 0;
      this.size = 0;
      this.hasAce = false;
   } // end of Hand()

   /**
    * Adds card to hand. Method catches an 
    * 'ArrayIndexOutOfBoundsException' if 
    * hand already holds maximum number of
    * cards and displays message to the console.
    *
    * @param card this is a Card object
    *
   **/
   public void addCard ( Card card ) {
      try {
         this.hand[this.size++] = card;
         this.handValue += card.getValue();
         this.hasAce = card.isAce() ? true : this.hasAce ;
      }
      catch ( ArrayIndexOutOfBoundsException e ) {
         this.size--;
         System.out.print( "\n" );
         System.out.print( e.toString() );
         System.out.print( "\n" );
         System.out.print( "Hand can't have more than " + this.size + " cards!" );
         System.out.print( "\n" );
      }
      
   } // end of addCard()

   /**
    * This method returns the sum value of all the cards
    * in the hand. If at least one Ace exists, the method 
    * adds 10 additional points to the comulative sum if 
    * and only the sum value does not go above 21. 
    *
    * @return int
    *
   **/
   public int getValue () {
      return ( this.hasAce & ( this.handValue + 10 ) <= 21 ? ( this.handValue + 10 ) : this.handValue );
   } // end of getValue()

   /**
    * This method prints the tags of all the cards in
    * the hand to the console.
    *
   **/
   public void showCards () {
      System.out.print( "\t" );
      for ( int i = 0; i < this.size ; i++ ) {
         System.out.print( this.hand[i].toString() + " " );
      }
   }

   // Declare private instance variables
   private Card[] hand; // to hold card objects
   private int handValue; // to hold card value sum
   private int size; // counter to keep track of # of cards
   private boolean hasAce; // to indicate whether hand has an Ace
}