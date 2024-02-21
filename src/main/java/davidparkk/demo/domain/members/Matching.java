package davidparkk.demo.domain.members;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Matching {

    @Id
    private String id;

    public Matching(){

    }
    public Matching(String id){
        this.id= id;
    }
}
