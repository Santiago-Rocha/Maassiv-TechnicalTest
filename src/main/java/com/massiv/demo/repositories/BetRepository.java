package com.massiv.demo.repositories;

import com.massiv.demo.model.Bet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

/**
 * @author <a href="santiago.rocha.duran@gmail.com">Santiago Rocha</a>
 */
public interface BetRepository extends CrudRepository<Bet, UUID> {
    List<Bet> findAllByRoundId(UUID roundId);
}
