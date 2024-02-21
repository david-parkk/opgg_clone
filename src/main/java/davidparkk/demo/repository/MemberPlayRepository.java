package davidparkk.demo.repository;


import davidparkk.demo.domain.members.Member;
import davidparkk.demo.domain.members.MemberPlay;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;

@Repository
public interface MemberPlayRepository extends JpaRepository<MemberPlay,Integer> {


}
