package com.massiv.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.UUID;

@Data
@NoArgsConstructor
@RedisHash("Round")
public class Round {
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
}
