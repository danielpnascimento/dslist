package com.devsuperior.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

//Essa anotação Embeddable/capsulando serve para pontuar que essa
// classe representará dois campos na tabela relacional
@Embeddable
public class BelongingPK {

    //Relação de muitos para 1
    //E associando ambos na tabela
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList list;

    public BelongingPK() {
    }

    public BelongingPK(Game game, GameList list) {
        this.game = game;
        this.list = list;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameList getList() {
        return list;
    }

    public void setList(GameList list) {
        this.list = list;
    }

    //Criando uma base de comparação tanto no game como na lista
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BelongingPK that = (BelongingPK) o;
        return Objects.equals(getGame(), that.getGame()) && Objects.equals(getList(), that.getList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGame(), getList());
    }
}
