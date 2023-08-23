package davidparkk.demo.service;


import davidparkk.demo.domain.members.Member;
import davidparkk.demo.domain.members.MemberPlay;
import davidparkk.demo.repository.MemberPlayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberPlayService {

    private final MemberPlayRepository memberPlayRepository;


    @Transactional(readOnly = false)
    public void addMember(String nickname){
        MemberPlay memberPlay=new MemberPlay(nickname);
        System.out.println("==== make"+memberPlay.getNickname());
        System.out.println("==== make"+memberPlay.getPlayTime());
        System.out.println("==== make"+memberPlay.getEnterTime());
        System.out.println("==== make"+memberPlay.getWinGame());
        System.out.println("==== make"+memberPlay.getLostGame());
        memberPlayRepository.save(memberPlay);

    }
    @Transactional(readOnly = false)
    public void updateInfo(String nickname,int playTime,int enterTime,int windGame,int lostGame){
        memberPlayRepository.updateOne(nickname,playTime,enterTime,windGame,lostGame);
    }
}
