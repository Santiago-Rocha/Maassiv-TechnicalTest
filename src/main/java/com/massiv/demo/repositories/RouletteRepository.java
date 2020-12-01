package com.massiv.demo.repositories;

import com.massiv.demo.model.Roulette;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * @author <a href="santiago.rocha.duran@gmail.com">Santiago Rocha</a>
 */
public interface RouletteRepository extends CrudRepository<Roulette, UUID> {
}
