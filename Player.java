package blackjack;
/* File name : player.java */

/**
 * This class represents a player in a game of Blackjack.
 * A regular player has a hand and balance from which to place bets. 
 *
 * @author Rodrigo Rogel-Perez
 * @version 1.0
**/

public class Player extends BlackjackPlayer {

   /**
    * Constructor with complete initialization.
    * Player starts with a balance of $100.00.
    *
   **/
   public Player () {
      super();
      this.balance = 100;
   } // end of Player()

   /**
    * Alternative onstructor with complete initialization.
    * Starting balance amount must be specified in the parameter.
    *
    * @param balance starting balance amount
    *
   **/
   public Player ( double balance ) {
      this.balance = balance;
   } // end of Player()

   /**
    * This method returns the player's remaining balance
    *
    * @return double
    *
   **/
   public double getBalance () {
      return this.balance;
   } // end of getBalance()

   /**
    * This method returns a boolean indicating
    * whether the player's balance is zero.
    *
    * @return boolean
    *
   **/
   public boolean isBalanceZero () {
      return ( this.balance == 0 );
   } // end of isBlanceZero()

   /**
    * This method adds the given amount to
    * the player's balance. 
    *
    * @param amount this is the amount to be added
    *
   **/
   public void addToBalance ( double amount ) {
      this.balance = (double) Math.round( (this.balance + amount) * 100.0 ) / 100;
   } // end of addToBalance()

   /**
    * This method subtracts the given amount from
    * the player's balance. 
    *
    * @param amount this is the amount to be subtracted
    *
   **/
   public void subtractFromBalance ( double amount ) {
      this.balance = (double) Math.round( (this.balance - amount) * 100.0 ) / 100;
   } // end of subtractFromBalance()

   // private instance variables
   private double balance; // to hold player's balance
} // end of Player