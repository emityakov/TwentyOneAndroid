package com.example.twentyone;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Game {

    //Declare variables needed for Game class
    private Deck deck, discarded;

    private Dealer dealer;
    private Player player;
    private int wins, losses, pushes;



    public Game(){

        //Create a new deck with 52 cards
        deck = new Deck(true);
        //Create a new empty deck
        discarded = new Deck();

        //Create the People
        dealer = new Dealer();
        player = new Player();


        //Shuffle the deck and start the first round
        deck.shuffle();
        //startRound(view, editText);
    }

    //This  method will handle the logic for each round
    public void startRound(TextView view, EditText editText) {
        if(wins>0 || losses>0 || pushes > 0){
            view.append("Starting Next Round... Wins: " + wins + " Losses: "+ losses+ " Pushes: "+pushes);
        }

        //Give the dealer two cards
        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);

        //Give the player two cards
        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);

        //Print their hands
        view.append(dealer.printFirstHand());
        view.append(player.printHand());

        player.makeDecision(deck, discarded, view, editText);

        view.append(dealer.printHand());

        while(dealer.getHand().scoreCount()<17){
            dealer.hit(deck, discarded, view);
        }

        if(player.getHand().scoreCount()>21){
            view.append("You busts\n");
            losses++;
        }
        else if(dealer.getHand().scoreCount()>21){
           view.append("Dealer busts\n");
            wins++;
        }
        else if(dealer.getHand().scoreCount() > player.getHand().scoreCount()){
            view.append("You lose\n");
            losses++;
        }
        else if(player.getHand().scoreCount() > dealer.getHand().scoreCount()){
            view.append("You win\n");
            wins++;
        }
        else{
            view.append("Push\n");
        }

        //Start a new round
        //startRound(view, editText);
    }

}