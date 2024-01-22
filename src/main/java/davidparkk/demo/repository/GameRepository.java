package davidparkk.demo.repository;

import davidparkk.demo.domain.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class GameRepository {

    private final EntityManager em;

    public void save(Game game) {
        em.persist(game);
    }

    public Game findOneById(int id) {
        return em.find(Game.class, id);
    }

    public Game findOneByGameId(String gameId) {
        return em.createQuery("select m from Game m where " +
                        "m.gameId=gameId", Game.class)
                .setParameter("gameId", gameId)
                .getSingleResult();
    }

    public boolean find(String gameId) {
        if (findOneByGameId(gameId) == null)
            return false;
        else
            return true;
    }

}
