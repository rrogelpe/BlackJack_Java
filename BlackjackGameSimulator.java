package blackjack;
/* File name : BlackjackGameSimulator.java */

import java.util.Scanner;

/**
 * This class simulates a game of Blackjack. In this game,
 * a single player plays against the dealer. Player starts
 * with an initial balance of $100. Player can place a 
 * bet at the start of the game. If player loses, bet amount
 * is subtracted from balance, bet amount is added otherwise. 
 * If player's hand is a Blackjack, 150% of bet amount is added
 * to the balance.
 *
 * @author Rodrigo Rogel-Perez
 * @version 1.0
**/

class BlackjackGameSimulator {
   public static void main(String[] args) {
      
      Scanner input = new Scanner( System.in ); // initialize scanner
      Player player = new Player(100); // initialize player instance
      int gameNum = 1; // holds game number e.g. 'game 1', 'game 2', etc,.

      char playAgain; // to indicate whether player would like to contnue playing
      String playerMove; // to indicate which move the user select 'hit' or 'stay' 
      double betAmount; // bet placed by player
      Dealer dealer; // declare dealer instance

      // inside this block is the code simulating the game of BlackJack
      // code block will repeat unless player's balance is zero or 
      // player chooses to exit game
      do {
         // print the game number to the console
         System.out.print( "\n*****************************************\n" );
         System.out.print( "*\t\tGAME " + (gameNum++) + "\t\t\t*" );
         System.out.print( "\n*****************************************\n" );

         dealer = new Dealer(); // initialize dealer instance

         // prompt user to enter bet amount
         // placed bet cannot be greater than the player's balance
         do {
            System.out.print( "\n" );
            System.out.print( "Player Balance: $" + player.getBalance() );
            System.out.print( "\n" );
            System.out.print( "Place bet amount: $" );
            betAmount = input.nextDouble();
         } while ( betAmount < 0 | ( betAmount > player.getBalance() ) );

         // dealer deals two cards to the player
         player.addCardToHand( dealer.dealCard() );
         player.addCardToHand( dealer.dealCard() );

         System.out.print( "\n" );
         System.out.print( player.toString() ); // display player's hand value
         System.out.print( "\n" );
         player.showHand(); // display player's hand
         System.out.print( "\n" );

         // if the sum of the two dealt cards' values equals 21, player wins immediately
         if ( player.getHandValue() == 21) {
            System.out.print( "\n" );
            System.out.print( "Blackjack: Player Wins!" );
            player.addToBalance( betAmount * 1.5 ); // add 150% of bet to the player's balance
            System.out.print( "\n" );
         } 
         else {
            // dealer deals two cards to him/herself
            dealer.addCardToHand( dealer.dealCard() );
            Card dealtCard = dealer.dealCard();
            dealtCard.hideCard(); // second card dealt is hidden (facing down)
            dealer.addCardToHand( dealtCard );

            // dealer's hand value originally unknown
            System.out.print( "\n" );
            System.out.print( "Dealer's hand value: ??" ); 
            System.out.print( "\n" );
            dealer.showHand(); // display dealer's hand
            System.out.print( "\n" );
            
            // deal card to player until player chooses to stay or player's hand value is > 21
            do {
               do {
                  System.out.print( "\n" );
                  System.out.print( "'hit' or 'stay': "); // prompt user to enter 'hit' or 'stay'
                  playerMove = input.next(); // read user input
               } while ( !playerMove.equals( "hit" ) & !playerMove.equals( "stay" ) );

               // player chooses 'hit' 
               if ( playerMove.equals( "hit" ) ) {
                  System.out.print( "\n" );
                  player.addCardToHand( dealer.dealCard() ); // deal card to player
                  System.out.print( player.toString() ); // update player's hand value
                  System.out.print( "\n" );
                  player.showHand(); // update player's hand
                  System.out.print( "\n" );
               }
               // player's hand value is > 21, player loses and dealer wins
               if ( player.getHandValue() > 21 ) {
                  System.out.print( "\n" );
                  System.out.print( "Busted: Dealer Wins!" );
                  player.subtractFromBalance( betAmount ); // player loses bet
                  System.out.print( "\n" );
               }
            } while ( playerMove.equals( "hit" ) & ( player.getHandValue() < 21 ) );

            // code executes only after player chooses to 'stay'
            if ( player.getHandValue() <= 21 ) {
               dealtCard.revealCard(); // revealt dealer's face down card
               System.out.print( "\n" );
               System.out.print( dealer.toString() ); // update dealer's hand value
               System.out.print( "\n" );
               dealer.showHand(); // update dealer's hand
               System.out.print( "\n" );

               // if dealer's hand equals 21,  dealer wins immediately
               if ( dealer.getHandValue() == 21 ) {
                  System.out.print( "\n" );
                  System.out.print( "Blackjack: Dealer Wins!" );
                  player.subtractFromBalance( betAmount ); // player loses bet
                  System.out.print( "\n" );
               }

               // dealer deals cards to him/herself until hand value >= 17
               while ( dealer.getHandValue() < 17 ) {
                  dealer.addCardToHand( dealer.dealCard() ); // deal card to dealer
                  System.out.print( "\n" );
                  System.out.print( dealer.toString() ); // update dealer's hand value
                  System.out.print( "\n" );
                  dealer.showHand(); // update dealer's hand
                  System.out.print( "\n" );
               }

               // if dealer's hand > 21, player wins
               if ( dealer.getHandValue() > 21 ) {
                  System.out.print( "\n" );
                  System.out.print( "Busted: Player Wins!" );
                  player.addToBalance( betAmount ); // add bet amount to player' balance
                  System.out.print( "\n" );
               }
            }

            // code block inside executes if both player and dealer hand values are < 21
            if ( dealer.getHandValue() <= 21 & player.getHandValue() <= 21 ) {
               System.out.print( "\n" );
               // dealer and player have same hand value i.e. dealer and player tie
               if ( player.getHandValue() == dealer.getHandValue() ) {
                  System.out.print( "It's A Tie!" );
               }
               // player wins if hand value is greater than dealer's
               else if ( player.getHandValue() > dealer.getHandValue() ) {
                  System.out.print( "Player Wins!" );
                  player.addToBalance( betAmount );
               } else { // dealer wins otherwise
                  System.out.print( "Dealer Wins!" );
                  player.subtractFromBalance( betAmount );
               }
               System.out.print( "\n" );
            } 
         }

         player.emptyHand(); // empty player's hand (represents cards going back into deck)
         System.out.print( "\n" );
         // display player's remaining net balance 
         System.out.print( "Remaning Player Balance: $" + player.getBalance() );
         System.out.print( "\n" );

         // game automatically exits if player's balance is zero
         if ( player.isBalanceZero() ) {
            System.out.print( "\n" );
            System.out.print( "Game Over: Player is out of money!" );
            System.out.print( "\n" );
            playAgain = 'n'; // assign 'n' to playAgain var (required to exit game)
         } 
         else {
            // prompt user to enter 'y' or 'n' indicating whether they would like
            // to continue playing
            do {
               System.out.print( "\n" );
               System.out.print( "Play Again? ('y' or 'n'): "); // prompt player
               playAgain = input.next().charAt(0); // read first character of user' input
            } while ( playAgain != 'y' & playAgain != 'n' ); // exit only if input is valid
         }
      } while ( playAgain == 'y' ); // game of blackjack continues as long as player enter 'y'

      // display goodbye message to user.
      System.out.print( "\n" );
      System.out.print( "Exiting Blackjack..." );
      System.out.print( "\n" );
      System.out.print( "Play again soon!" );
      System.out.print( "\n" );
   }
}