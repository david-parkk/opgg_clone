package davidparkk.demo.service;

import davidparkk.demo.domain.members.Member;
import davidparkk.demo.domain.members.MemberDetail;
import davidparkk.demo.domain.members.MemberPlay;
import davidparkk.demo.domain.riotApi.Participant;
import davidparkk.demo.domain.riotApi.Summoner;
import davidparkk.demo.repository.MemberDetailRepository;
import davidparkk.demo.repository.MemberPlayRepository;
import davidparkk.demo.repository.MemberRepository;
import davidparkk.demo.riotApi.RiotApiRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//import java.net.http.HttpHeaders;

@Service
@Transactional(readOnly = false)
@RequiredArgsConstructor
public class MemberService {


    public final MemberRepository memberRepository;
    public final RiotApiRepository riotApiRepository;
    public final MemberDetailRepository memberDetailRepository;
    public final MemberPlayRepository memberPlayRepository;

    public void addMember(String summoner){
        if(memberRepository.alreadySave(summoner))
            return;
        Summoner summonerInfo = riotApiRepository.getSummonerInfo(summoner);
        Member member=new Member(summonerInfo.getName(),0,summonerInfo.getPuuid(),summonerInfo.getProfileIconId());

        MemberDetail memberDetail=new MemberDetail(member);
        MemberPlay memberPlay=new MemberPlay(member);
        member.setMemberInfo(memberDetail,memberPlay);
        memberPlayRepository.save(memberPlay);
        memberDetailRepository.save(memberDetail);
        memberRepository.save(member);


    }

    public List<Member> getValidSummoner(Map<String, Participant> participantMap){
        List<Member>validSummonerList=new ArrayList<>();
        for (String summoner : participantMap.keySet()) {
            Member member=memberRepository.findOneBySummoner(summoner);
            if(member==null)
                continue;
            validSummonerList.add(member);

        }
        return validSummonerList;
    }



}
