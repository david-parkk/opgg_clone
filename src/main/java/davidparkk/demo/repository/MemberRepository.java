package davidparkk.demo.repository;


import davidparkk.demo.domain.members.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member){
        em.persist(member);//update 처리 로직 추가해야됨
        /*em.flush();
        em.close();*/
    }
    public void deleteByNickname(String nickname){
        Member findMember=em.find(Member.class,nickname);
        em.remove(findMember);
    }
    public Member findOne(String nickname){
        return em.find(Member.class,nickname);
    }

    public List<Member> findALl(){//모든 사용자에 대한 대전기록및 데이터 업데이트
        return em.createQuery("select  m from Member as m ",Member.class)
                .getResultList();
    }
}
