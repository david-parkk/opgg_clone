package davidparkk.demo.domain.riotApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming
public class Participant {

    @JsonProperty("riotIdGameName")
    private String summoner;

    @JsonProperty("kills")
    private int kill;

    @JsonProperty("assists")
    private int assist;

    @JsonProperty("deaths")
    private int death;

    @JsonProperty("totalDamageDealtToChampions")
    private int damage;

    @JsonProperty("totalDamageTaken")
    private int damageTaken;

    private boolean win;

    @Override
    public String toString() {
        return "Participant{" +
                "summoner='" + summoner + '\'' +
                ", kill=" + kill +
                ", assist=" + assist +
                ", death=" + death +
                ", damage=" + damage +
                ", damageTaken=" + damageTaken +
                ", win=" + win +
                '}';
    }
}
