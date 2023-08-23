package davidparkk.demo.repository;


import davidparkk.demo.domain.members.MemberPlay;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MemberPlayRepository {

    private final EntityManager em;

    public void save(MemberPlay memberPlay){
        em.persist(memberPlay);
        em.flush();
        em.close();
    }

    public MemberPlay findOne(String nickname){
        return em.find(MemberPlay.class,nickname);
    }


    public void updateOne(String name,int playTime,int enterTime,int windGame,int lostGame){
        MemberPlay memberPlay=this.findOne(name);
        memberPlay.update(playTime,enterTime,windGame,lostGame);
    }
}
