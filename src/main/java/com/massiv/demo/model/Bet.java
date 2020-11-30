package com.massiv.demo.model;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public abstract class Bet {
    private UUID id;
    private UUID rouletteId;
    private int amount;
    private Instant betTime;
    private int award;
    public abstract void calculateAward (int winNumber);
}
