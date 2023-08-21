package davidparkk.demo.repository;

import davidparkk.demo.domain.Match;
import davidparkk.demo.domain.members.MemberDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MatchRepository {

    private final EntityManager em;

    public void save(Match match){
        em.persist(match);
    }
    public Match findOne(String id) {
        return em.find(Match.class,id);

    }
    public boolean find(String id){

        if(em.find(Match.class,id)==null)
            return false;
        else {
            return true;
        }
    }

}
