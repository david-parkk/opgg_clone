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
    }

    public MemberPlay findOne(String nickname){
        return em.find(MemberPlay.class,nickname);
    }

}
