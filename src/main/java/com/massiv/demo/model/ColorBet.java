package com.massiv.demo.model;

public class ColorBet extends Bet {
    private BetColor color;
    @Override
    public void calculateAward(int winNumber) {
        if(winNumber%2 == 0 && color == BetColor.RED){
            setAward(10*getAmount());
        }
        if(winNumber%2 == 1 && color == BetColor.BLACK){
            setAward(10*getAmount());
        }
    }
}
