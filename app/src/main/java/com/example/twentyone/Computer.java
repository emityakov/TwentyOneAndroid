package com.example.twentyone;

public class Computer extends Player {


    public Computer(){

        //Name the dealer "Dealer"
        super.setName("Диллер");

    }

    public String printFirstHand(){
        return "У диллера следующая карта:\n" + super.getHand().getCard(0) +
                "\nВторая карта лежит рубашкой вверх.\n";
    }

}