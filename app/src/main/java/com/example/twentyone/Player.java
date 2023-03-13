package com.example.twentyone;

import android.widget.EditText;
import android.widget.TextView;

public class Player extends Person {

    //Create a new Player
    public Player() {

        super.setName("Player");

    }


    public void makeDecision(Deck deck, Deck discard, TextView textView, EditText editText) {

        int  decision = 0;
        boolean getNum = true;

        while(getNum){

            try{
                textView.append("Would you like to: 1) Hit or 2) Stand\n");
                decision = Integer.parseInt(editText.getText().toString());
                getNum = false;

            }
            catch(Exception e){
                textView.append("Invalid\n");
                //input.next();
            }
            //we don't close the scanner, because we will need it later.
        }

        //if they decide to hit
        if (decision == 1) {
            //hit the deck using the deck and discard deck
            this.hit(deck, discard, textView);
            //return (exit the method) if they have blackjack or busted
            if(this.getHand().scoreCount()>20){
                return;
            }
            //if they didnt bust or get 21, allow them to decide to hit or stand again by going back to this same method
            else{
                this.makeDecision(deck, discard, textView, editText);
            }

            //if they type any number other than 1, we'll assume they're standing
        } else {
            textView.append("You stand\n");
        }
    }
}