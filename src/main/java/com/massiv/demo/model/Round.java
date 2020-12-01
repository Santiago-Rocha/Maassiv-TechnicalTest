package com.massiv.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.Random;
import java.util.UUID;

/**
 * Represents a round of play in roulette
 *
 * @author <a href="santiago.rocha.duran@gmail.com">Santiago Rocha</a>
 */
@Data
@NoArgsConstructor
@RedisHash("Round")
public class Round {
    public static final int NOT_PLAYED_ROUND = -1;
    @Id
    private UUID id;
    @Indexed
    private UUID rouletteId;
    @Indexed
    private int winnerNumber;
    public Round(UUID rouletteId, int winnerNumber){
        this.rouletteId = rouletteId;
        this.winnerNumber = winnerNumber;
    }
    public void calculateWinnerNumber(){
        if(winnerNumber == NOT_PLAYED_ROUND){
            Random random =  new Random();
            winnerNumber = random.nextInt(NumberBet.MAX_NUMBER - NumberBet.MIN_NUMBER  + 1) + NumberBet.MIN_NUMBER;
        }
    }
}
