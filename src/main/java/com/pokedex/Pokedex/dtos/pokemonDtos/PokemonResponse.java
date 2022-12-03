package com.pokedex.Pokedex.dtos.pokemonDtos;

import com.pokedex.Pokedex.models.Pokemon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PokemonResponse {


    long id;

    int numberPokedex;

    String name;

    String type;
}
