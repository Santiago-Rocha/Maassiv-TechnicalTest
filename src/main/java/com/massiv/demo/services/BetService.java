package com.massiv.demo.services;

import com.massiv.demo.exceptions.RouletteException;
import com.massiv.demo.model.Bet;

import java.util.UUID;

public interface BetService {
    UUID createBet(UUID rouletteId, Bet bet) throws RouletteException;
}
