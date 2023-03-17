package com.example.twentyone;

import android.widget.TextView;

public class Game {

    //Declare variables needed for Game class
    private Deck deck, discarded;

    private Computer computer;
    private Human human;

    public Game(){

        //Create a new deck with 52 cards
        deck = new Deck(true);
        //Create a new empty deck
        discarded = new Deck();

        //Create the People
        computer = new Computer();
        human = new Human();

        //Shuffle the deck and start the first round
        deck.shuffle();
        //startRound(view, editText);
    }

    //This  method will handle the logic for each round
    public void startRound(TextView view) {
        //Give the dealer two cards
        computer.getHand().takeCardFromDeck(deck);
        computer.getHand().takeCardFromDeck(deck);

        //Give the player two cards
        human.getHand().takeCardFromDeck(deck);
        human.getHand().takeCardFromDeck(deck);

        //Print their hands
        view.append(computer.printFirstHand());
        view.append(human.printHand());

    }

    public boolean isGameOver() {
        return !human.canHit();
    }


    public boolean makeDecision(TextView view, boolean b){
        return human.makeDecision(deck, discarded, view, b);
    }

    public void endRound(TextView view){
        view.append(computer.printHand());
        while(computer.getHand().scoreCount()<17){
            computer.hit(deck, discarded, view);
        }

        if(human.getHand().scoreCount()>21){
            view.append("У вас перебор!\n");
        }
        else if(computer.getHand().scoreCount()>21){
            view.append("У диллера перебор!\n");
        }
        else if(computer.getHand().scoreCount() > human.getHand().scoreCount()){
            view.append("Вы проиграли!\n");
        }
        else if(human.getHand().scoreCount() > computer.getHand().scoreCount()){
            view.append("Вы выйграли!\n");
        }
        else{
            view.append("Ничья!\n");
        }
    }

}