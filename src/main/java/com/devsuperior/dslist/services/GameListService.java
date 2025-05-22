package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Anotação que faz o registro da service e a
//anotação @Component faz a mesmo
@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    //Busca geral no banco
    //Anotação importante usar o Transactional do spring e não do jakarta
    //E deixando ela com readonly para deixa mais rapida a busca
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        //Função que transforma uma lista de Game acima em uma lista de game Listdto
        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        return dto;
    }


}
