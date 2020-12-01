package com.massiv.demo.controllers;

import com.massiv.demo.exceptions.RouletteException;
import com.massiv.demo.model.Bet;
import com.massiv.demo.repositories.BetRepository;
import com.massiv.demo.repositories.RoundRepository;
import com.massiv.demo.services.BetService;
import com.massiv.demo.services.RouletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/roulette")
public class RouletteController {
    private final RouletteService rouletteService;
    private final BetService betService;
    private final RoundRepository roundRepository;
    @Autowired
    BetRepository betRepository;
    RouletteController(RouletteService rouletteService, BetService betService, RoundRepository roundRepository){
        this.rouletteService = rouletteService;
        this.betService = betService;
        this.roundRepository = roundRepository;
    }
    @GetMapping
    public ResponseEntity<?>getRoulette(){
        return new ResponseEntity<>(rouletteService.getAllRoulettes(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> createRoulette(){

        return new ResponseEntity<>(rouletteService.createRoulette(), HttpStatus.OK);
    }
    @PutMapping("/open/{rouletteId}")
    public ResponseEntity<?> openRoulette(@PathVariable UUID rouletteId){
        try {

            return new ResponseEntity<>(rouletteService.openRoulette(rouletteId),HttpStatus.OK);
        } catch (RouletteException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/close/{rouletteId}")
    public ResponseEntity<?> closeRoulette(@PathVariable UUID rouletteId){
        try {

            return new ResponseEntity<>(rouletteService.closeRoulette(rouletteId),HttpStatus.OK);
        } catch (RouletteException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/bet/{rouletteId}")
    public ResponseEntity<?> makeBet(@PathVariable UUID rouletteId,@RequestBody Bet bet){
        try {
            return new ResponseEntity<>(betService.createBet(rouletteId,bet),HttpStatus.OK);
        } catch (RouletteException e) {

            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/tes")
    public ResponseEntity<?> gg(){
        return new ResponseEntity<>(roundRepository.findAll(),HttpStatus.OK);
    }
    @GetMapping("/tes2")
    public ResponseEntity<?> gg2(){
        return new ResponseEntity<>(betRepository.findAll(),HttpStatus.OK);
    }
}

