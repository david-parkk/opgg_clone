package davidparkk.demo.service;

import davidparkk.demo.domain.members.Matching;
import davidparkk.demo.repository.MatchingRepository;
import davidparkk.demo.riotApi.RiotApiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MatchingService {

    private final MatchingRepository matchingRepository;

    private final RiotApiRepository riotApiRepository;

    @Transactional(readOnly = true)
    public List<String>getMatchingByMember(String summoner,int count){
        return riotApiRepository.getGameIdList(summoner,count);
    }
    @Transactional(readOnly = true)
    public List<String> getValidMatching(List<String> matchingIdList){
        return matchingIdList.stream()
                .filter(m->matchingRepository.findById(m).isEmpty()).toList();
    }
    @Transactional
    public Matching saveByMatchingId(String matchingId){
        Matching matching=new Matching(matchingId);
        return matchingRepository.save(matching);
    }
}
