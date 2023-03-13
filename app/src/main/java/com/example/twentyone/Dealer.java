package com.example.twentyone;

public class Dealer extends Person{

    /**
     * Create a new Dealer
     */
    public Dealer(){

        //Name the dealer "Dealer"
        super.setName("Dealer");

    }

    public String printFirstHand(){
        return "The dealer's hand looks like this:\n" + super.getHand().getCard(0) +
                "\nThe second card is face down.\n";
    }

}