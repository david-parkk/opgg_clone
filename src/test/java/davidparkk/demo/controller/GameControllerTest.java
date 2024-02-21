package davidparkk.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import davidparkk.demo.domain.members.MemberDetail;
import davidparkk.demo.domain.members.MemberPlay;
import davidparkk.demo.repository.MemberDetailRepository;
import davidparkk.demo.repository.MemberPlayRepository;
import jakarta.transaction.Transactional;
import lombok.Builder;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameControllerTest {

    @Autowired
    GameController gameController;

    @Autowired
    MemberPlayRepository memberPlayRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("동일한 게임 매치에 대해서 중복 처리 테스트(최근에 같이 게임한 두명의 플레이로 변경해서 테스트)")
    @Transactional
    public void matchSaveTest() throws JsonProcessingException {
        gameController.add("풀뚜껑먹어라");
        gameController.add("signaloff");
        gameController.update("풀뚜껑먹어라",3);
        List<MemberPlay> memberPlayList = memberPlayRepository.findAll();
        Assertions.assertThat(memberPlayList.get(0).getLostGame()).isEqualTo(memberPlayList.get(1).getLostGame());
        Assertions.assertThat(memberPlayList.get(0).getEnterTime()).isEqualTo(memberPlayList.get(1).getEnterTime());
        Assertions.assertThat(memberPlayList.get(0).getWinGame()).isEqualTo(memberPlayList.get(1).getWinGame());


    }


}
