package com.devsuperior.dslist.repositories;

import com.devsuperior.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

//Ele faz as operações no banco como insert/select/update/delete
//Facilitando e agilizando
public interface GameListRepository extends JpaRepository<GameList,Long> {

}
