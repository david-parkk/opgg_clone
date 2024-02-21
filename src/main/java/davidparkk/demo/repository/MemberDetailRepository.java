package davidparkk.demo.repository;


import davidparkk.demo.domain.members.Member;
import davidparkk.demo.domain.members.MemberDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;

@Repository
public interface MemberDetailRepository extends JpaRepository<MemberDetail,Integer> {


}
