package com.massiv.demo.services;

import com.massiv.demo.exceptions.RouletteException;
import com.massiv.demo.model.Bet;
import com.massiv.demo.model.Round;
import com.massiv.demo.repositories.BetRepository;
import com.massiv.demo.repositories.RoundRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author <a href="santiago.rocha.duran@gmail.com">Santiago Rocha</a>
 */
@Service
public class BetServiceImp implements BetService {
    private final BetRepository betRepository;
    private final RoundRepository roundRepository;
    BetServiceImp(BetRepository betRepository, RoundRepository roundRepository){
        this.betRepository = betRepository;
        this.roundRepository = roundRepository;
    }
    @Override
    public UUID createBet(UUID rouletteId,Bet bet) throws RouletteException {
        Round round = roundRepository.findByWinnerNumberAndRouletteId(Round.NOT_PLAYED_ROUND,rouletteId);
        if(round != null){
            if(bet.isValid()){
                bet.setRoundId(round.getId());
                return betRepository.save(bet).getId();
            }
            else{
                throw new RouletteException("The bet not is valid");
            }
        }
        else{
            throw new RouletteException("Roulette must be open to make a bet");
        }
    }
}
