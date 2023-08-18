package davidparkk.demo.domain.members;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Member {

    @Id
    private String nickname;

    private Long medel;

    private String puuid;


    private String img_url;
    public Member(){

    }
    public Member(String nickname,String puuid,String img_url){
        this.nickname=nickname;
        this.puuid=puuid;
        this.img_url=img_url;
        this.medel=0L;

    }
    public void setImg_url(String img_url){
        this.img_url=img_url;
    }
    public void addMedal(){
        this.medel++;
        return;
    }

}
