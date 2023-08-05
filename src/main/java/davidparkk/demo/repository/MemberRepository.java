package davidparkk.demo.repository;


import davidparkk.demo.domain.members.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member){
        em.persist(member);//update 처리 로직 추가해야됨

    }

    public Member findOne(String nickname){
        return em.find(Member.class,nickname);
    }
}
