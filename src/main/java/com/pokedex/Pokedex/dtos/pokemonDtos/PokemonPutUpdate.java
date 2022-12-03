package com.pokedex.Pokedex.dtos.pokemonDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonPutUpdate {

    @NotBlank
    long id;

    @NotBlank
    int numberPokedex;

    @NotBlank
    String name;

    @NotBlank
    String type;
}
