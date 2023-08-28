package davidparkk.demo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RiotApiRepositoryTest {

    @Autowired
    RiotApiRepository riotApiRepository;

    @Test
    public void MatchTest() throws Exception {
        String matchId="KR_6661021821";
        //System.out.println(riotApiRepository.getMatchInfo(matchId));
        String matchInfo=riotApiRepository.getMatchInfo(matchId);
    }
}