package com.example.twentyone;

import android.widget.TextView;

public abstract class Person {

    private Hand hand;
    private String name;


    public Person(){
        this.hand = new Hand();
        this.name = "";
    }

    public Hand getHand(){
        return this.hand;
    }
    public void setHand(Hand hand){
        this.hand = hand;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;

    }

    public boolean hasBlackjack(){
        if(this.getHand().scoreCount() == 21){
            return true;
        }
        else{
            return false;
        }
    }

    public String printHand(){
        return this.name + "'s hand looks like this: " +
                this.hand + " Valued at: " + this.hand.scoreCount() + '\n';
    }

    public void hit(Deck deck, Deck discard, TextView textView){

        //If there's no cards left in the deck
        if (!deck.hasCards()) {
            deck.reloadDeckFromDiscard(discard);
        }
        this.hand.takeCardFromDeck(deck);
        textView.append(this.name + " gets a card\n" + this.printHand() + '\n');

    }

}