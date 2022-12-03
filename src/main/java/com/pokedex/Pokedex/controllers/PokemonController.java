package com.pokedex.Pokedex.controllers;

import com.pokedex.Pokedex.dtos.pokemonDtos.PokemonPutUpdate;
import com.pokedex.Pokedex.dtos.pokemonDtos.PokemonRequest;
import com.pokedex.Pokedex.dtos.pokemonDtos.PokemonResponse;
import com.pokedex.Pokedex.dtos.pokemonDtos.PokemonPatchUpdate;
import com.pokedex.Pokedex.models.Pokemon;
import com.pokedex.Pokedex.servicies.interfaces.PokemonService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    PokemonService pokemonServices;

    @PostMapping
    public ResponseEntity<PokemonResponse> create(@RequestBody PokemonRequest pokemon){
        return new ResponseEntity<>(pokemonServices.create(pokemon), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> page(Pageable pageable){
        return new ResponseEntity<>(pokemonServices.page(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Pokemon> getBydId(@PathVariable long id){
        return pokemonServices.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        pokemonServices.deleteById(id);
    }

    @PatchMapping
    public PokemonPatchUpdate update(PokemonPatchUpdate pokemon){
        return pokemonServices.update(pokemon);
    }

    @PutMapping
    public PokemonPutUpdate remake(PokemonPutUpdate pokemonPutUpdate){
        return pokemonServices.remake(pokemonPutUpdate);
    }

}
