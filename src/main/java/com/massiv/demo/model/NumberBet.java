package com.massiv.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class NumberBet extends Bet {
    private int number;
    @Override
    public void calculateAward(int winNumber) {
        if(number==winNumber){
            setAward(5*getAmount());
        }
    }
}
