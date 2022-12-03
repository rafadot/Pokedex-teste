package com.pokedex.Pokedex.dtos.pokemonDtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonRequest {

    @NotBlank
    int numberPokedex;

    @NotBlank
    String name;

    @NotBlank
    String type;

}
