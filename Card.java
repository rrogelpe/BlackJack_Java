package blackjack;
/* File name : Card.java */

/**
 * This class represents a card in a game of Blackjack.
 * Methods can be invoked to get the value and suit of 
 * an instance of this class. A card can also be hidden
 * or revealed. In the former, the value and suit will
 * replaced with question marks '??'
 *
 * @author Rodrigo Rogel-Perez
 * @version 1.0
**/

public class Card {
   
   /**
    * Constructor with complete initialization
    * 
    * @param value card's value e.g. 3, 7, 12
    * @param suit card's suit e.g. 'S' for spades, 'D' for diamonds 
    * @param isHidden used to indicate whether card is face down
    *
   **/
   public Card ( int value, String suit, boolean isHidden ) {
      this.value = value;
      this.suit = suit;
      this.isHidden = isHidden;
   } // end of Card()

   /**
    * Alternative constructor with complete initialization.
    * In this version, the 'isHidden' attribute is set to 
    * 'false' by default.
    * 
    * @param value card's value e.g. 3, 7, 12
    * @param suit card's suit e.g. 'S' for spades, 'D' for diamonds 
    *
   **/
   public Card ( int value, String suit ) {
      this.value = value;
      this.suit = suit;
      this.isHidden = false;
   } // end of Card()

   /**
    * This method returns the value of the card. 
    * Numbered cards are worth their number. 
    * All face cards are worth 10.
    *
    * @return int
    *
   **/
   public int getValue () {
      return ( ( this.value > 10 ) ? 10 : this.value );
   } // end of getValue()

   /**
    * This method returns the first letter of the card's suit.
    * There are four distinct suits and every card will be of one. 
    * 'D' is for 'Diamonds', 'S' is for 'Spades', 'C' is for 
    * 'Clubs', 'H' is for 'Hearts'.
    * 
    * @return String 
    *
   **/
   public String getSuit () {
      return this.suit;
   } // end of getSuit()

   /**
    * This method generates a short tag for the card.
    * The tag is a combination of the card's suit and 
    * its value. If the instance variable 'isHidden'
    * is set to false, the tag will only show question 
    * marks.
    *
    * @return String
    *
   **/
   public String toString () {
      String rank = this.value == 1 ? "A" : 
         this.value == 11 ? "J" :
         this.value == 12 ? "Q" : 
         this.value == 13 ? "K" : 
         Integer.toString( this.value );

      return ( this.isHidden ? ( "[?|?]" ) : ( "[" + rank + "|" + this.suit + "]" ) );
   } // end of getCard()

   /**
    * This method sets the attribute 'isHidden' of the 
    * card to 'false' thereby revealing its suit and 
    * value when the 'toString()' method is invoked.
    *
   **/
   public void revealCard () {
      this.isHidden = false;
   } // end of revealCard()

   /**
    * This method sets the attribute 'isHiden' of the 
    * card to 'false' thereby hiding its suit and value
    * when the 'toString()' method is invoked.
    *
   **/
   public void hideCard () {
      this.isHidden = true;
   }

   /**
    * This method returns a boolean indicating if the card
    * is an Ace. This helps determine whether a value of 1
    * or 11 should be assigned to the card based on the
    * remaining cards in the player's hand.
    *
    * @return boolean
    *
   **/
   public boolean isAce () {
      return ( ( this.value == 1 ) ? true : false );
   } // end of isAce()

   // Declare private instance variables
   private int value; // to hold value of card
   private String suit; // to hold suit of card
   private boolean isHidden; // to indicate whether card is face up or down
} // end of Card