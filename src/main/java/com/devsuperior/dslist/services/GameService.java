package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Anotação que faz o registro da service e a
//anotação @Component faz a mesma coisa
@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    //Busca geral no banco
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        //Função que transforma uma lista de Game acima em uma lista de game
        //dto
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

}
