package com.massiv.demo.repositories;

import com.massiv.demo.model.Round;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * @author <a href="santiago.rocha.duran@gmail.com">Santiago Rocha</a>
 */
public interface RoundRepository extends CrudRepository<Round, UUID> {
    Round findByWinnerNumberAndRouletteId(int num, UUID rouletteId);
}


