package davidparkk.demo.service;


import davidparkk.demo.domain.members.Member;
import davidparkk.demo.domain.members.MemberPlay;
import davidparkk.demo.repository.MemberPlayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberPlayService {


}
