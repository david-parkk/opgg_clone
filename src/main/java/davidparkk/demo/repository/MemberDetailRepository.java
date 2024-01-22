package davidparkk.demo.repository;


import davidparkk.demo.domain.members.Member;
import davidparkk.demo.domain.members.MemberDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MemberDetailRepository {

    private final EntityManager em;

    public void save(MemberDetail memberDetail){
        em.persist(memberDetail);
    }
    public MemberDetail findOneById(int id){
        return em.find(MemberDetail.class,id);
    }



}
