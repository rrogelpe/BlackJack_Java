package blackjack;
/* File name : Deck.java */

/**
 * This class represents a deck in a game of Blackjack.
 * Instances of the 'Card' class can be added to an
 * instance of this class. The top card of the deck
 * can be dealt. A method can be invoked on an instance
 * of this class to simulate shuffling.
 *
 * @author Rodrigo Rogel-Perez
 * @version 1.0
**/

public class Deck {
 
   /**
    * Constructor with complete initialization.
    * This version assumes there's one deck
    * which has 52 cards excluding the 2 jokers.
    *
   **/
   public Deck () {
      this.cards = new Card[52];
      this.size = 0;
   } // end of Deck()

   /**
    * Alternative constructor with complete initialization.
    * Number of decks must be specified in the parameter.
    *
    * @param numDecks the number of decks to be played with
    *
   **/
   public Deck ( int numDecks ) {
      this.cards = new Card[52 * numDecks];
      this.size = 0;
   } // end of Deck()

   /**
    * This method adds a card object to the player's
    * hand which is an object itself. If no more cards
    * can be added to the hand, the method catches
    * an 'ArrayIndexOutOfBoundsException' and displays
    * a message in the console.
    *
   **/
   public void addCard ( Card card ) {
      try {
         this.cards[this.size++] = card;   
      } catch ( ArrayIndexOutOfBoundsException e ) {
         this.size--;
         System.out.print( "\n" );
         System.out.print( e.toString() );
         System.out.print( "\n" );
         System.out.print( (this.size / 52) + " deck(s) can't have more than " + this.size + " cards in total!" );
         System.out.print( "\n" );
      }
   } // end of addCard()

   /**
    * This method simulates a deck shuffle by swapping 
    * every card in the deck with a another random card.
    *
   **/
   public void shuffle () {
      int randNum;

      for ( int i = 0; i < this.size ; i++ ) {
         randNum = (int) ( this.size * Math.random() );
         Card temp = this.cards[i];
         this.cards[i] = this.cards[randNum];
         this.cards[randNum] = temp;
      }
   } // end of shuffle()

   /**
    * This method returns the first card at the top 
    * of the deck. If no cards remain, the method
    * catches an 'ArrayIndexOutOfBoundsException'
    * and displays message in the console.
    *
   **/
   public Card drawCard () {
      try {
         return this.cards[--this.size];
      } catch ( ArrayIndexOutOfBoundsException e ) {
         this.size++;
         System.out.print( "\n" );
         System.out.print( e.toString() );
         System.out.print( "\n" );
         System.out.print( "Dealer is out of cards!" );
         System.out.print( "\n" );
      }

      return null;
   } // end of drawCard()

   /**
    * This method returns a boolean indicating whether the deck
    * is empty i.e. no cards remain in the deck.
    *
    * @return boolean 
    *
   **/
   public boolean isEmpty () {
      return ( this.size == 0 );
   } // isEmpty()

   // Declare private instance variables
   private Card[] cards; // to store instances of the 'Card' class
   private int size; // to hold number of cards in the deck
} // end of Deck