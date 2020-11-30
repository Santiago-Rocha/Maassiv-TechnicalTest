package com.massiv.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class ColorBet extends Bet {
    private BetColor color;
    @Override
    public void calculateAward(int winNumber) {
        if((winNumber%2 == 0 && color == BetColor.RED) || (winNumber%2 == 1 && color == BetColor.BLACK)){
            setAward(1.8*getAmount());
        }
    }
}
