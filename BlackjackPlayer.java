package blackjack;
/* File name : BlackjackPlayer.java */

/**
 * This class represents a player in a game of Blackjack.
 * All players in blackjack have a hand. 
 *
 * @author Rodrigo Rogel-Perez
 * @version 1.0
**/

public class BlackjackPlayer {

   public BlackjackPlayer () {
      this.playerHand = new Hand();
   }

   /**
    * This method invokes the 'getValue()' method defined
    * in the 'Hand' class. It is invoked in the 'playerHand'
    * instance variable.  
    *
    * @return int
    *
   **/
   public int getHandValue () {
      return this.playerHand.getValue();
   } // end of getHandValue()

   /**
    * This method invokes the 'addCard()' method defined
    * in the 'Hand' class. It is invoked in the 'playerHand'
    * instance variable.  
    *
    * @param card this is a Card object
    *
   **/
   public void addCardToHand ( Card card ) {
      this.playerHand.addCard( card );
   } // end of addCardToHand()

   /**
    * This method prints the tags of all the cards in
    * the hand to the console. It invokes the 'showCards()'
    * defined in the 'Hand' class.
    *
   **/
   public void showHand () {
      this.playerHand.showCards();
   } // end of showHand()

   /**
    * This method returns a string with the 
    * player's hand value.
    *
    * @return String
    *
   **/
   public String toString () {
      return ( "Player's hand value: " + getHandValue() );   
   } // end of toString()

   /**
    * This method sets the 'playerHand' instance variable
    * to a new instance of the 'Hand' class. Essentially, 
    * this represents cards going back into the deck.
    *
   **/
   public void emptyHand () {
      this.playerHand = new Hand();
   } // end of emptyHand()

   // define private instance variables
   private Hand playerHand; // represents player's hand
} // end of BlackjackPlayer