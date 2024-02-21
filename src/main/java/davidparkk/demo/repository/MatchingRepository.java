package davidparkk.demo.repository;

import davidparkk.demo.domain.members.Matching;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatchingRepository extends JpaRepository<Matching, String> {

    Optional<Matching> findById(String id);


    Matching save(String id);
}
