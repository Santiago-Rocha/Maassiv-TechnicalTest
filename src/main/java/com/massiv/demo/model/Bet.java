package com.massiv.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ColorBet.class, name = "color"),
        @JsonSubTypes.Type(value = NumberBet.class, name = "number")
})
public abstract class Bet {
    public static final int MIN_BET = 1;
    public static final int MAX_BET = 10000;
    @Id
    private UUID id;
    @Indexed
    private UUID roundId;
    private double amount;
    private double award;
    public abstract void calculateAward (int winNumber);
    @JsonIgnore
    public boolean isValid(){

        return amount>= MIN_BET && amount <= MAX_BET;
    }
}
