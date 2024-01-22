package davidparkk.demo.domain.members;

import davidparkk.demo.domain.riotApi.Info;
import davidparkk.demo.domain.riotApi.Participant;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class MemberPlay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private long playTime;//함께 플레이 시간

    private long enterTime;//함께 참여한 횟수

    private int winGame;

    private int lostGame;

    @OneToOne(mappedBy = "memberPlay", fetch = FetchType.LAZY)
    private Member member;

    public MemberPlay(){
        this.playTime=0;
        this.enterTime=0;
        this.winGame=0;
        this.lostGame=0;
    }
    public MemberPlay(Member member){
        this.member=member;
        this.playTime=0;
        this.enterTime=0;
        this.winGame=0;
        this.lostGame=0;
    }

    public void updateWinOrLose(Participant participant){
        boolean win=participant.isWin();
        if(win)
            this.winGame++;
        else
            this.lostGame++;
    }
    public void updateTime(Info info){
        this.playTime=info.getPlayTime();
        this.enterTime=info.getPlayTime();
    }

}
