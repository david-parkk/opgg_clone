package davidparkk.demo.domain.riotApi;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class GameReceiver {
    private final WebClient webClient;

    public GameReceiver() {
        this.webClient = WebClient.create();
    }

    public Mono<String> getGame(String gameId, String apiKey) {
        String url = "https://asia.api.riotgames.com/lol/match/v5/matches/" + gameId + "?api_key=" + apiKey;

        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class);
    }
}
