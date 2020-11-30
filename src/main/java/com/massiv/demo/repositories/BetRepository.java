package com.massiv.demo.repositories;

import com.massiv.demo.model.Bet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface BetRepository extends CrudRepository<Bet, UUID> {
    List<Bet> findAllByRoundId(UUID roundId);
}
