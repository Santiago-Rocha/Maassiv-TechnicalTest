package com.massiv.demo.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.time.Instant;
import java.util.UUID;

@Data
@RedisHash("Bet")
public abstract class Bet {
    @Id
    private UUID id;
    @Indexed
    private UUID roundId;
    private int amount;
    private int award;
    public abstract void calculateAward (int winNumber);
}
