package davidparkk.demo.repository;


import davidparkk.demo.domain.members.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }
    public boolean alreadySave(String summoner){
        if(findOneBySummoner(summoner)==null)
            return false;
        return true;
    }

    public Member findOneBySummoner(String summoner) {
        try {
            return em.createQuery("select  m from Member m where " +
                            "m.summoner=:summoner", Member.class)
                    .setParameter("summoner", summoner)
                    .getSingleResult();
        }
        catch (Exception e) {
            return null;
        }

    }
    public String getPuuidBySummoner(String summoner){
        try {
            return em.createQuery("select  m from Member m where " +
                            "m.summoner=:summoner", Member.class)
                    .setParameter("summoner", summoner)
                    .getSingleResult().getPuuid();
        }
        catch (Exception e) {
            return null;
        }
    }
    public void deleteBySummoner(String summoner) {
        em.remove(findOneBySummoner(summoner));
    }

    public void deleteById(int id) {
        em.remove(findOneById(id));
    }

    public Member findOneById(int id) {
        return em.find(Member.class, id);
    }

    public void updateMember(String beforeSummoner,String afterSummoner ){
        findOneBySummoner(beforeSummoner).setSummoner(afterSummoner);
    }
    public List<Member> findALl() {//모든 사용자에 대한 대전기록및 데이터 업데이트
        return em.createQuery("select  m from Member as m ", Member.class)
                .getResultList();
    }
}
