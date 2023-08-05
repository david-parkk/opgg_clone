package davidparkk.demo.domain;


import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class Match {

    @Id
    private String id;

    public Match(){

    }
    public Match(String id){
        this.id=id;
    }
}
