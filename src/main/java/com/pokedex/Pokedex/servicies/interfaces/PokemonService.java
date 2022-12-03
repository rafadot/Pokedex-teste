package com.pokedex.Pokedex.servicies.interfaces;

import com.pokedex.Pokedex.dtos.pokemonDtos.PokemonPutUpdate;
import com.pokedex.Pokedex.dtos.pokemonDtos.PokemonRequest;
import com.pokedex.Pokedex.dtos.pokemonDtos.PokemonResponse;
import com.pokedex.Pokedex.dtos.pokemonDtos.PokemonPatchUpdate;
import com.pokedex.Pokedex.models.Pokemon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface PokemonService {

    PokemonResponse create(PokemonRequest pokemonRequest);

    Page<Pokemon> page(Pageable pageable);

    Optional<Pokemon> findById(Long id);

    void deleteById(Long id);

    PokemonPatchUpdate update(PokemonPatchUpdate pokemonUpdate);

    PokemonPutUpdate remake(PokemonPutUpdate pokemonPutUpdate);


}
