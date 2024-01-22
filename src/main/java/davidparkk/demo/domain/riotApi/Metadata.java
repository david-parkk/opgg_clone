package davidparkk.demo.domain.riotApi;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonNaming
public class Metadata {
    String dataVersion;

    String matchId;

    List<String>participants;
}
