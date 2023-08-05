package davidparkk.demo.domain.members;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class MemberDetail {
    @Id
    private String nickname;

    private int kill;
    private int death;
    private int dealing;
    private int demaged;


    public MemberDetail(){

    }
    public MemberDetail(String nickname){
        this.nickname=nickname;
        this.kill=0;
        this.death=0;
        this.dealing=0;
        this.demaged=0;
    }
}
