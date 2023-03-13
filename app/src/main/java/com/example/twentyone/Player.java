package com.example.twentyone;

import android.widget.EditText;
import android.widget.TextView;

public class Player extends Person {

    //Create a new Player
    public Player() {
        super.setName("Player");
    }


    public boolean makeDecision(Deck deck, Deck discard, TextView textView, boolean b) {

        //if they decide to hit
        if (b) {
            //hit the deck using the deck and discard deck
            this.hit(deck, discard, textView);
            //return (exit the method) if they have blackjack or busted
            if(this.getHand().scoreCount()>20){
                return false;
            }
            else {
                return true;
            }
            /*//if they didnt bust or get 21, allow them to decide to hit or stand again by going back to this same method
            else{
                this.makeDecision(deck, discard, textView, true);
            }
            */
            //if they type any number other than 1, we'll assume they're standing
        } else {
            textView.append("You stand\n");
            return false;
        }
    }
}