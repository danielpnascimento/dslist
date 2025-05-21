package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//Anotação que faz o registro da service e a
//anotação @Component faz a mesmo
@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    //Metodo para buscar por ID
    //Da GameDTO criada
    //Anotação importante usar o Transactional do spring e não do jakarta
    //E deixando ela com readonly para deixa mais rapida a busca
    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }

    //Busca geral no banco
    //Anotação importante usar o Transactional do spring e não do jakarta
    //E deixando ela com readonly para deixa mais rapida a busca
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        //Função que transforma uma lista de Game acima em uma lista de game dto
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }


}
