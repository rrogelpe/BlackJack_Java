package blackjack;
/* File name : Dealer.java */

/**
 * This class represents a dealer in a game of Blackjack.
 * A dealer has a hand and deals cards from the deck. 
 *
 * @author Rodrigo Rogel-Perez
 * @version 1.0
**/

public class Dealer extends BlackjackPlayer {

   /**
    * Constructor with complete initialization.
    * One deck (52 cards) is generated and shuffled.
    *
   **/
   public Dealer () {
      super();
      String suit; // to hold one of four suits
      this.deckOfCards = new Deck(); // initialize deck
      // generate cards
      for ( int i = 1; i <= 4; i++ ) {
         for ( int j = 1 ; j <= 13 ; j++ ) {
            suit = i == 1 ? "S" : i == 2 ? "H" : i == 3 ? "C" : "D";
            // add card to deck
            this.deckOfCards.addCard( new Card( j, suit ) );
         }
      }
      // shuffle deck
      this.deckOfCards.shuffle();
   } // end of Dealer()

   /**
    * Alternative constructor with complete initialization.
    * Number of decks must be specified in the paramater.
    *
    * @param numDecks this is the number of decks
    *
   **/
   public Dealer ( int numDecks ) {
      String suit; // to hold one of four suits
      this.deckOfCards = new Deck( numDecks ); // initialize deck
      // genarate 52 cards per deck
      for ( int i = 0; i < numDecks ; i++ ) {
         for ( int j = 1; j <= 4; j++ ) {
            for ( int l = 1 ; l <= 13 ; l++ ) {
               suit = ( j == 1 ) ? "S" : ( j == 2 ) ? "H" : ( j == 3 ) ? "C" : "D";
               // add card to deck
               this.deckOfCards.addCard( new Card( l, suit ) );
            }
         }  
         this.deckOfCards.shuffle(); // shuffle deck
      }
   } // end of Dealer()

   /**
    * This method simulates the shuffling of a deck. It invokes
    * the 'shuffle()' method defined in the 'Deck' class on the 
    * 'deckOfCards' instance variable.
    *
   **/
   public void shuffleDeck () {
      this.deckOfCards.shuffle();
   } // end of shuffleDeck()

   /**
    * This method simulates the dealer dealing a card. It invokes
    * the 'drawCard()' object defined in the 'Deck' class on the 
    * 'deckOfCards' instance variable.
    *
    * @return Card object
    *
   **/
   public Card dealCard ( ) {
      return this.deckOfCards.drawCard();
   } // end of drawCard()

   /**
    * This method returns a string with the 
    * dealer's hand value.
    *
    * @return String
    *
   **/
   public String toString () {
      return ( "Dealer's hand value: " + getHandValue() );
   }

   /**
    * This method returns a boolean indicating whether 
    * the deck is empty. It invokes the 'isEmpty()' 
    * method defined in the 'Deck' class on the 'deckIfCards'
    * instance variable.
    * 
    * @return boolean
    *
   **/
   public boolean isDeckEmpty() {
      return this.deckOfCards.isEmpty();
   } // end of isDeckEmpty()

   // private instance variables
   private Deck deckOfCards; // represents deck of cards
} // end of Dealer