package com.massiv.demo.services;

import com.massiv.demo.exceptions.RouletteException;
import com.massiv.demo.model.Bet;
import com.massiv.demo.model.Roulette;

import java.util.List;
import java.util.UUID;

public interface RouletteService {
    List<Roulette> getAllRoulettes();
    UUID createRoulette();
    UUID openRoulette(UUID rouletteId) throws RouletteException;
    List<Bet> closeRoulette(UUID rouletteId) throws RouletteException;
}
