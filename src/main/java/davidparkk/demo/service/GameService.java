package davidparkk.demo.service;

import davidparkk.demo.domain.members.Member;
import davidparkk.demo.domain.riotApi.Game;
import davidparkk.demo.domain.riotApi.Participant;
import davidparkk.demo.repository.MemberRepository;
import davidparkk.demo.riotApi.RiotApiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GameService {

    public final RiotApiRepository riotApiRepository;
    public final MemberService memberService;
    public final MemberRepository memberRepository;

    @Transactional
    public void updateMemberInfo(String summoner){
        String puuid = memberRepository.getPuuidBySummoner(summoner);
        String[] gameList= riotApiRepository.getGameIdList(puuid,1);
        for (String gameId : gameList) {
            System.out.println("asdfadsf");
            Game game = riotApiRepository.getGameInfo(gameId);

            for (Participant participant1 : game.getInfo().getParticipants()) {
                System.out.println(participant1.toString());
            }

            Map<String, Participant> participantMap = game.getInfo().getParticipantMap();
            List<Member> validMemberList = memberService.getValidSummoner(participantMap);
            if(validMemberList.size()<=1)
                return;
            System.out.println();
            for (Member member : validMemberList) {
                Participant participant = participantMap.get(member.getSummoner());
                member.getMemberDetail().update(participant);
                member.getMemberPlay().updateTime(game.getInfo());
                member.getMemberPlay().updateWinOrLose(participant);
            }
        }



    }

}
