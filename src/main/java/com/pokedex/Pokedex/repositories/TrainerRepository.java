package com.pokedex.Pokedex.repositories;


import com.pokedex.Pokedex.models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {

}
