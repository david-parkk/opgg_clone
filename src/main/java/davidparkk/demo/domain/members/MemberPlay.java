package davidparkk.demo.domain.members;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class MemberPlay {

    @Id
    private String nickname;

    private int playTime;//함께 플레이 시간

    private int enterTime;//함께 참여한 횟수

    private int winGame;

    private int lostGame;
    public MemberPlay(){

    }

    public MemberPlay(String nickname){
        this.nickname=nickname;
        this.playTime=0;
        this.enterTime=0;
        this.winGame=0;
        this.lostGame=0;

    }

    public void update(int playTime,int enterTime,int winGame,int lostGame){
        this.playTime+=playTime;
        this.enterTime+=enterTime;
        this.winGame+=winGame;
        this.lostGame+=lostGame;
    }

}
