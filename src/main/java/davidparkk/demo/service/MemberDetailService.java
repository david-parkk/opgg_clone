package davidparkk.demo.service;


import davidparkk.demo.domain.members.MemberDetail;
import davidparkk.demo.domain.members.MemberPlay;
import davidparkk.demo.repository.MemberDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Id;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberDetailService {

    private final MemberDetailRepository memberDetailRepository;

    @Transactional(readOnly = false)
    public void addMember(String nickname){
        MemberDetail memberDetail=new MemberDetail(nickname);
        memberDetailRepository.save(memberDetail);



    }
    public boolean isMember(String nickname){
        if(memberDetailRepository.findOne(nickname)!=null){
            return true;
        }
        else{
            return false;
        }
    }

    @Transactional(readOnly = false)
    public void updateInfo(String nickname,int kill,int death,int dealing,int demaged){
        memberDetailRepository.updateOne(nickname, kill, death, dealing, demaged);
    }
}
