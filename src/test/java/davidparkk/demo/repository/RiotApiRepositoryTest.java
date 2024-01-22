package davidparkk.demo.repository;

import davidparkk.demo.domain.riotApi.Game;
import davidparkk.demo.domain.riotApi.Summoner;
import davidparkk.demo.riotApi.RiotApiRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RiotApiRepositoryTest {

    @Autowired
    public RiotApiRepository riotApiRepository;
    @Test
    public void getSummonerInfoTest(){
        String summoner="풀뚜껑먹어라";
        Summoner summonerInfo = riotApiRepository.getSummonerInfo(summoner);
        Assertions.assertThat(summonerInfo.getName()).isEqualTo(summoner);

    }
    @Test
    public void getGameIdList(){
        String puuid="7VJVqyqgvJ4WXiRafcaQMRIRJkIywU7FAe8FTrrlp2AemwVZVSb0BVn6C9xA9JG1HG6azgW2jiL13w";
        int count=10;
        String[] strings= riotApiRepository.getGameIdList(puuid,count);
        Assertions.assertThat(strings.length).isEqualTo(count);
    }
    @Test
    public void getGameInfo(){
        String gameId="KR_6911490356";
        Game gameInfo = riotApiRepository.getGameInfo(gameId);
        Assertions.assertThat(gameInfo.getInfo().getParticipantMap().size()).isEqualTo(10);
    }

}