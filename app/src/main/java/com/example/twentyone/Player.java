package com.example.twentyone;

import android.widget.EditText;
import android.widget.TextView;

public class Player extends Person {
    private boolean isStand = false;

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
        } else {
            isStand = true;
            textView.append("You stand\n");
            return false;
        }
    }

    public boolean canHit() {
        return getHand().scoreCount() < 21 && !isStand;
    }
}