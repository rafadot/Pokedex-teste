package com.pokedex.Pokedex.controllers;

import com.pokedex.Pokedex.models.Trainer;
import com.pokedex.Pokedex.repositories.TrainerRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trainer")
public class TrainerController {

    @Autowired
    TrainerRepository trainerRepository;

    @PostMapping
    ResponseEntity<Trainer> create(@RequestBody Trainer trainer){
        return new ResponseEntity<>(trainerRepository.save(trainer), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<Trainer>> getAll(){
        return new ResponseEntity<List<Trainer>>(trainerRepository.findAll(),HttpStatus.OK);
    }
}
