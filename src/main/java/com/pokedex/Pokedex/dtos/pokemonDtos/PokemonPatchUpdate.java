package com.pokedex.Pokedex.dtos.pokemonDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PokemonPatchUpdate {

    @NotBlank
    long id;

    int numberPokedex;

    String name;

    String type;

}
