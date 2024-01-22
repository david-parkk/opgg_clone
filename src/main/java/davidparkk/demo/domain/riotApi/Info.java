package davidparkk.demo.domain.riotApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@JsonNaming
public class Info {

    String gameMode;

    @JsonProperty("gameDuration")
    long playTime;

    @JsonProperty("gameStartTimestamp")
    Date time;

    List<Participant> participants;

    Map<String,Participant>participantMap=new HashMap<>();

    public void makeMap(){
        for (Participant participant : participants) {
            this.participantMap.put(participant.getSummoner(),participant);
        }
    }
}
