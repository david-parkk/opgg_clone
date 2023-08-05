package davidparkk.demo.repository;


import davidparkk.demo.domain.members.MemberDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MemberDetailRepository {

    private final EntityManager em;

    public void save(MemberDetail memberDetail){
        em.persist(memberDetail);
    }
    public MemberDetail findOne(String id){
        return em.find(MemberDetail.class,id);
        /*if(em.find(MemberDetail.class,id)==null)
            return false;
        else {
            return true;
        }*/
    }
}
