package davidparkk.demo.repository;


import davidparkk.demo.domain.members.Member;
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
    public MemberDetail findOne(String nickname){
        return em.find(MemberDetail.class,nickname);
        /*if(em.find(MemberDetail.class,id)==null)
            return false;
        else {
            return true;
        }*/
    }
    public void updateOne(String nickname,int kill,int death,int dealing,int demaged){
        MemberDetail memberDetail=this.findOne(nickname);
        memberDetail.update(kill, death, dealing, demaged);
    }

}
