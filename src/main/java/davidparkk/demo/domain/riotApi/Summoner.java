package davidparkk.demo.domain.riotApi;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonNaming
public class Summoner {
    String id;
    String accountId;
    String puuid;
    String name;
    String profileIconId;
    String summonerLevel;

}
