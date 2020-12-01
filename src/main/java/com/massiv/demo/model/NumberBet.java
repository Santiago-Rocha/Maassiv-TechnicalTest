package com.massiv.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class NumberBet extends Bet {
    private int number;
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 36;
    @Override
    public void calculateAward(int winNumber) {
        if(number==winNumber){
            setAward(5*getAmount());
        }
    }

    @Override
    public boolean isValid() {

        return super.isValid() && number >= MIN_NUMBER && number <= MAX_NUMBER;
    }
}
