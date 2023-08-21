package davidparkk.demo.domain.members;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MatchStruct {
    public List<String>nicknames;
    public List<Integer>kills;
    public List<Integer>deaths;
    public List<Integer>dealings;
    public List<Integer>demageds;
    public List<Boolean>wins;

    public int playTime;
    public MatchStruct(){
        this.nicknames = new ArrayList<>();
        this.kills = new ArrayList<>();
        this.deaths = new ArrayList<>();
        this.dealings=new ArrayList<>();
        this.demageds = new ArrayList<>();
        this.wins=new ArrayList<>();
        this.playTime = 0;
    }


    public MatchStruct(List<String> nicknames, List<Integer> kills, List<Integer> deaths, List<Integer> dealings, List<Integer> demageds, List<Boolean> wins, int playTime) {
        this.nicknames = nicknames;
        this.kills = kills;
        this.deaths = deaths;
        this.dealings = dealings;
        this.demageds = demageds;
        this.wins = wins;
        this.playTime = playTime;
    }
}
