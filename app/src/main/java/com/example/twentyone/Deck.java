package com.example.twentyone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Stack;

public class Deck {
    private Stack<Card> deck = new Stack();


    public Deck(){
        initDeck();
    }

    public Deck(boolean makeDeck){
        deck = new Stack<>();
        if(makeDeck){
            //Go through all the suits
            for(Card.Suit suit : Card.Suit.values()){
                //Go through all the ranks
                for(Card.Rank rank : Card.Rank.values()){
                    //add a new card containing each iterations suit and rank
                    deck.add(new Card(rank,suit));
                }
            }
        }
    }

    private void initDeck() {
        deck.clear();
        for(Card.Rank rank: Card.Rank.values()){
            for(Card.Suit suit: Card.Suit.values()) {
                deck.push(new Card(rank, suit));
            }
        }
    }


    public String toString(){
        //Строка для хранения всего, что мы собираемся вернуть
        StringBuilder output = new StringBuilder();

        //создаем итератор
        Iterator iterator = deck.iterator();

        //проходим по всей коллекции
        while(iterator.hasNext()) {
            Card card = (Card) iterator.next();
            output.append(card);
            output.append("\n");
        }

        return output.toString();
    }


    public void shuffle(){
        Collections.shuffle(deck, new Random());
    }

    public Card takeCard(){
        //Берем карту и удаляем ее из колоды
        Card card = new Card(deck.pop());
        return card;
    }

    public boolean hasCards(){
        if (deck.size()>0){
            return true;
        }
        else{
            return false;
        }
    }

    public int cardsLeft(){
        return deck.size();
    }

    /**
     * Empties out this Deck
     */
    public void emptyDeck(){
        deck.clear();
    }


    public void addCards(ArrayList<Card> cards){
        deck.addAll(cards);
    }



    public void reloadDeckFromDiscard(Deck discard){
        //this.addCards(discard.addCards(d));
        this.shuffle();
        discard.emptyDeck();
    }
}