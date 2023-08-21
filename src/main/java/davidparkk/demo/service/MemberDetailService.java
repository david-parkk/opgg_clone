package davidparkk.demo.service;


import davidparkk.demo.repository.MemberDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberDetailService {

    private final MemberDetailRepository memberDetailRepository;

    public boolean isMember(String nickname){
        if(memberDetailRepository.findOne(nickname)!=null){
            return true;
        }
        else{
            return false;
        }
    }
}
