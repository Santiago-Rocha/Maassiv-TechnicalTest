package com.massiv.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.Instant;
import java.util.UUID;

@RedisHash("Roulette")
@Data
@AllArgsConstructor
public class Roulette {
    @Id
    private UUID id;
    private RouletteState state;
    private Instant openTime;
    private Instant closeTime;
    public Roulette(){
        state = RouletteState.CLOSE;
    }
}
