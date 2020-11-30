package com.massiv.demo.model;

public class NumberBet extends Bet {
    private int number;
    @Override
    public void calculateAward(int winNumber) {
        if(number==winNumber){
            setAward(10*getAmount());
        }
    }
}
