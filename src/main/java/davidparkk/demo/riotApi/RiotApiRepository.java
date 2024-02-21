package davidparkk.demo.riotApi;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import davidparkk.demo.domain.riotApi.Game;
import davidparkk.demo.domain.riotApi.Summoner;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RiotApiRepository {

    public final RestTemplate restTemplate;

    public final WebClient webClient;

    @Value("${riot.api-key}")
    private String apiKey;
    public Summoner getSummonerInfo(String summoner){
        String url="https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+summoner+"?api_key="+apiKey;
        return restTemplate.getForEntity(url, Summoner.class).getBody();
    }

    public List<String> getGameIdList(String puuid, int count){
        String url = "https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/"+puuid+"/ids?start=0&count="+count+"&api_key="+apiKey;
        String[] strings = restTemplate.getForEntity(url, String[].class).getBody();
        return Arrays.asList(strings);
        //string 배열로 꼭 써야할까?
    }

    public Game getGameInfo(String gameId){
        String url = "https://asia.api.riotgames.com/lol/match/v5/matches/" + gameId + "?api_key=" + apiKey;

        Mono<String> response= webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class);
        String responseString = response.block();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            Game game = objectMapper.readValue(responseString, Game.class);
            game.getInfo().makeMap();
            return game;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }




}