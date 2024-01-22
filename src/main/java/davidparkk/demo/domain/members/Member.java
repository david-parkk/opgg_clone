package davidparkk.demo.domain.members;

import davidparkk.demo.service.MemberService;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import org.springframework.context.annotation.Primary;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String summoner;

    private int medal;

    private String puuid;

    private String profileIconId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private MemberPlay memberPlay;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private MemberDetail memberDetail;

    public Member(){

    }

    public void setSummoner(String summoner) {
        this.summoner = summoner;
    }

    public Member(String summoner, int medal, String puuid, String profileIconId) {
        this.summoner = summoner;
        this.medal = medal;
        this.puuid = puuid;
        this.profileIconId = profileIconId;
    }

    public void setMemberInfo(MemberDetail memberDetail, MemberPlay memberPlay){
        this.memberDetail=memberDetail;
        this.memberPlay=memberPlay;
    }
    public void setImg_url(String img_url){
        this.profileIconId=profileIconId;
    }
    public void addMedal(){
        this.medal++;
        return;
    }

}
