package davidparkk.demo.service;


import davidparkk.demo.domain.members.MatchStruct;
import davidparkk.demo.domain.members.Member;
import davidparkk.demo.domain.members.MemberDetail;
import davidparkk.demo.repository.MemberDetailRepository;
import davidparkk.demo.repository.RiotApiRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MatchServiceTest {

    @Autowired
    MatchService matchService;
    @Autowired
    MemberDetailRepository memberDetailRepository;
    @Autowired
    RiotApiRepository riotApiRepository;


    @Test
    @Transactional
    public void findMatchInfoTest() {
        //given
        String nickname="풀뚜껑먹어라" ;
        MemberDetail memberDetail=new MemberDetail(nickname);
        memberDetailRepository.save(memberDetail);
        String matchId="KR_6661021821";

        //when

        String matchInfo=riotApiRepository.getMatchInfo(matchId);
        MatchStruct matchStruct=matchService.parsingInfo(matchInfo);

        //then
        Assertions.assertThat(matchStruct.nicknames.get(0)).isEqualTo("풀뚜껑먹어라");
        Assertions.assertThat(matchStruct.playTime).isEqualTo(1631);
        Assertions.assertThat(matchStruct.kills.get(0)).isEqualTo(3);
        Assertions.assertThat(matchStruct.deaths.get(0)).isEqualTo(5);
        Assertions.assertThat(matchStruct.demageds.get(0)).isEqualTo(17998);
        Assertions.assertThat(matchStruct.dealings.get(0)).isEqualTo(6390);
    }

    @Test
    @Transactional
    public void parsingTest() {
        //given
        String nickname1="풀뚜껑먹어라" ;
        MemberDetail memberDetail=new MemberDetail(nickname1);
        memberDetailRepository.save(memberDetail);
        String matchId="KR_6661021821";
        //when
        String matchInfo=riotApiRepository.getMatchInfo(matchId);
        MatchStruct matchStruct=matchService.parsingInfo(matchInfo);
        //then
        for(int i=0;i<10;i++){
            System.out.println(matchStruct.getNicknames().get(i));
        }

    }
}
