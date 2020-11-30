package com.massiv.demo.services;

import com.massiv.demo.model.Bet;
import com.massiv.demo.model.Roulette;

import java.util.List;
import java.util.UUID;

public interface RouletteService {
    List<Roulette> getAllRoulettes();
    UUID createRoulette();
    UUID openRoulette(UUID rouletteId);
    List<Bet> closeRoulette(UUID rouletteId);
}
