package davidparkk.demo.domain.riotApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming
@JsonIgnoreProperties(ignoreUnknown = true)
public class Game {

    private Metadata metadata;
    private Info info;



}
