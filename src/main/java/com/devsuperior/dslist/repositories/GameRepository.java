package com.devsuperior.dslist.repositories;

import com.devsuperior.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

//Ele faz as operações no banco como insert/select/update/delete
//Facilitando e agilizando
public interface GameRepository extends JpaRepository<Game,Long> {

}
