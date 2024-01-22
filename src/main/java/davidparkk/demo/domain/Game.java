package davidparkk.demo.domain;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Getter
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String gameId;

    public Game(){

    }
    public Game(String gameId){
        this.gameId =gameId;
    }
}
