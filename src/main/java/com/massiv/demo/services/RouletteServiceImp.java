package com.massiv.demo.services;

import com.massiv.demo.exceptions.RouletteException;
import com.massiv.demo.model.*;
import com.massiv.demo.repositories.BetRepository;
import com.massiv.demo.repositories.RouletteRepository;
import com.massiv.demo.repositories.RoundRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RouletteServiceImp implements RouletteService {
    private final RouletteRepository rouletteRepository;
    private final BetRepository betRepository;
    private final RoundRepository roundRepository;
    RouletteServiceImp(RouletteRepository rouletteRepository, BetRepository betRepository, RoundRepository roundRepository){
        this.rouletteRepository = rouletteRepository;
        this.betRepository = betRepository;
        this.roundRepository = roundRepository;
    }
    @Override
    public List<Roulette> getAllRoulettes() {
        List<Roulette> roulettes = new ArrayList<>();
        rouletteRepository.findAll().forEach(roulettes::add);

        return roulettes;
    }
    @Override
    public UUID createRoulette() {

        return rouletteRepository.save(new Roulette()).getId();
    }
    @Override
    public UUID openRoulette(UUID rouletteId) throws RouletteException {
        Optional<Roulette> optionalRoulette = rouletteRepository.findById(rouletteId);
        if(optionalRoulette.isPresent()){
            Roulette roulette = optionalRoulette.get();
            roulette.open();
            roundRepository.save(new Round(rouletteId, Round.NOT_PLAYED_ROUND));
            return rouletteRepository.save(roulette).getId();
        }else {
            throw new RouletteException("Roulette with id: "+rouletteId+" not exists");
        }

    }
    @Override
    public List<Bet> closeRoulette(UUID rouletteId) throws RouletteException{
        Optional<Roulette> optionalRoulette = rouletteRepository.findById(rouletteId);
        if(optionalRoulette.isPresent()){
            Roulette roulette = optionalRoulette.get();
            if (roulette.getState() == RouletteState.OPEN) {
                roulette.close();
                rouletteRepository.save(roulette);
                Round round = roundRepository.findByWinnerNumberAndRouletteId(Round.NOT_PLAYED_ROUND,rouletteId);
                round.calculateWinnerNumber();
                roundRepository.save(round);

                return getBetAwards(round);
            }
            else{
                throw new RouletteException("Roulette "+rouletteId+" must be open");
            }
        }else {
            throw new RouletteException("Roulette with id: "+rouletteId+" not exists");
        }
    }
    private List<Bet> getBetAwards(Round round){
        List<Bet> bets = betRepository.findAllByRoundId(round.getId());
        bets.forEach(b -> {
            b.calculateAward(round.getWinnerNumber());
            betRepository.save(b);
        });

        return bets;
    }
}
