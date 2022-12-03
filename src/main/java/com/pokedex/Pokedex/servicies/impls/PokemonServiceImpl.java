package com.pokedex.Pokedex.servicies.impls;

import com.pokedex.Pokedex.dtos.pokemonDtos.PokemonPutUpdate;
import com.pokedex.Pokedex.dtos.pokemonDtos.PokemonRequest;
import com.pokedex.Pokedex.dtos.pokemonDtos.PokemonResponse;
import com.pokedex.Pokedex.dtos.pokemonDtos.PokemonPatchUpdate;
import com.pokedex.Pokedex.models.Pokemon;
import com.pokedex.Pokedex.repositories.PokemonRepository;
import com.pokedex.Pokedex.servicies.interfaces.PokemonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PokemonServiceImpl implements PokemonService {

    @Autowired
    PokemonRepository pokemonRepository;

    @Override
    @Transactional
    public PokemonResponse create(PokemonRequest pokemonRequest) {
        Pokemon pokemon = new Pokemon();
        PokemonResponse pokemonResponse= new PokemonResponse();

        BeanUtils.copyProperties(pokemonRequest,pokemon);
        pokemonRepository.save(pokemon);
        BeanUtils.copyProperties(pokemon,pokemonResponse);

        return pokemonResponse;
    }

    @Override
    public Page<Pokemon> page(Pageable pageable) {
        return pokemonRepository.findAll(pageable);
    }

    @Override
    public Optional<Pokemon> findById(Long id) {
        return pokemonRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        pokemonRepository.deleteById(id);
    }

    @Override
    public PokemonPatchUpdate update(PokemonPatchUpdate pokemonUpdate) {
        Pokemon pokemon = pokemonRepository.getReferenceById(pokemonUpdate.getId());

        if(pokemonUpdate.getName() == null){
            pokemonUpdate.setName(pokemon.getName());
        }

        if(pokemonUpdate.getNumberPokedex() == 0){
            pokemonUpdate.setNumberPokedex(pokemon.getNumberPokedex());
        }

        if(pokemonUpdate.getType() == null){
            pokemonUpdate.setType(pokemon.getType());
        }

        BeanUtils.copyProperties(pokemonUpdate, pokemon);
        pokemonRepository.save(pokemon);

        return pokemonUpdate;
    }

    @Override
    public PokemonPutUpdate remake(PokemonPutUpdate pokemonPutUpdate) {
        Pokemon pokemon = new Pokemon();
        BeanUtils.copyProperties(pokemonPutUpdate, pokemon);

        pokemonRepository.save(pokemon);

        return pokemonPutUpdate;
    }

}
