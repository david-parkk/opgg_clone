package davidparkk.demo.service;

import davidparkk.demo.domain.Match;
import davidparkk.demo.domain.members.MatchStruct;
import davidparkk.demo.domain.members.MemberDetail;
import davidparkk.demo.repository.MatchRepository;
import davidparkk.demo.repository.RiotApiRepository;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;
    private final RiotApiRepository riotApiRepository;
    private final MemberDetailService memberDetailService;
    private final MemberPlayService memberPlayService;

    public MatchStruct parsingInfo(String matchInfo){
        MatchStruct matchStruct=new MatchStruct();
        JSONObject jsonObject1=new JSONObject(matchInfo);
        JSONObject jsonObject2=(JSONObject) jsonObject1.get("info");
        matchStruct.gameMode=(String)jsonObject2.get("gameMode");
        matchStruct.playTime=(int)jsonObject2.get("gameDuration");
        JSONArray jsonArray=(JSONArray)(jsonObject2.get("participants"));

        for(int i=0; i<jsonArray.length(); i++){
            JSONObject jsonObj = (JSONObject)jsonArray.get(i);
            //String nickname=(String)jsonObj.get("summonerName");
            //System.out.println((String)jsonObj.get("summonerName"));

            matchStruct.nicknames.add((String) jsonObj.get("summonerName"));

            matchStruct.kills.add((int)jsonObj.get("kills"));
            matchStruct.deaths.add((int)jsonObj.get("deaths"));
            matchStruct.dealings.add((int)jsonObj.get("totalDamageDealtToChampions"));
            matchStruct.demageds.add((int)jsonObj.get("totalDamageTaken"));
            matchStruct.wins.add((boolean)jsonObj.get("win"));
            //System.out.println((String)jsonObj.get("summonerName")+"찾음!!!");

            //System.out.println((String)jsonObj.get("summonerName")+"못찾음!!!");

        }
        return matchStruct;
    }
    @Transactional(readOnly = true)
    public void addMatch(String matchId){
        if(!matchRepository.find(matchId)){

            Match match=new Match(matchId);
            matchRepository.save(match);
            String matchDetail=riotApiRepository.getMatchInfo(matchId);
            MatchStruct matchStruct=parsingInfo(matchDetail);
            int count =0;
            for(int i=0;i<matchStruct.getNicknames().size();i++) {
                if(memberDetailService.isMember(matchStruct.getNicknames().get(i))){
                    count++;
                }

            }
            System.out.println("========"+matchStruct.getGameMode());
            if (count <2||!matchStruct.getGameMode().equals("CLASSIC"))
                return;
            for(int i=0;i<matchStruct.dealings.size();i++) {
                if(!memberDetailService.isMember(matchStruct.getNicknames().get(i))) {
                    continue;
                }
                memberDetailService.updateInfo(matchStruct.nicknames.get(i),matchStruct.kills.get(i),matchStruct.deaths.get(i),matchStruct.dealings.get(i),matchStruct.demageds.get(i));
                int win=(matchStruct.wins.get(i))? 1 : 0;;
                int lose=(!matchStruct.wins.get(i))? 1 : 0;;
                memberPlayService.updateInfo(matchStruct.nicknames.get(i),matchStruct.getPlayTime(),1,win,lose);
            }
            //여기서 정보 받고 detail,play service로 넘김
        }
    }
}
