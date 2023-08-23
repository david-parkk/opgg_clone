package davidparkk.demo.service;

import davidparkk.demo.domain.Match;
import davidparkk.demo.domain.members.Member;
import davidparkk.demo.domain.members.MemberDetail;
import davidparkk.demo.repository.MatchRepository;
import davidparkk.demo.repository.MemberRepository;
import davidparkk.demo.repository.RiotApiRepository;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import org.json.JSONObject;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;
import java.util.List;
import java.util.concurrent.ExecutionException;
//import java.net.http.HttpHeaders;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {


    private final MemberRepository memberRepository;
    private final RiotApiRepository riotApiRepository;
    private final MatchService matchService;

    public Boolean addMember(String nickname){
        String puuid=riotApiRepository.getPuuid(nickname);
        if(puuid=="fail"){
            return false;
        }
        else {

            Member member = new Member(nickname, puuid, "null");

            memberRepository.save(member);
            return true;
        }
    }
    public void updateData(){
        List<Member>members =memberRepository.findALl();
        for (Member member : members) {
            //member가 참여한 대전id이  저장
            //member에서 대전 id를 array로 받아오면 match에 넘겨서 match에서 다시 member 로 저장??
            List<String> matchs=riotApiRepository.getMatchIds(member.getPuuid());
            for (String match : matchs) {
                matchService.addMatch(match);
            }
        }
    }

}
