package com.massiv.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


import java.util.UUID;

@RedisHash("Roulette")
@Data
@AllArgsConstructor
public class Roulette {
    @Id
    private UUID id;
    private RouletteState state;
    public Roulette(){
        state = RouletteState.CLOSE;
    }
    public void open(){
        this.state = RouletteState.OPEN;
    }
    public void close(){
        this.state = RouletteState.CLOSE;
    }
}
