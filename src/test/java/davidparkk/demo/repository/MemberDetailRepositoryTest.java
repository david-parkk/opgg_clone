package davidparkk.demo.repository;


import davidparkk.demo.domain.members.MemberDetail;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberDetailRepositoryTest {

    @Autowired MemberDetailRepository memberDetailRepository;

    @Test
    @Transactional
    public void MemberDetailPersist(){
        //given
        String nickname="풀뚜껑먹어라";
        MemberDetail memberDetail=new MemberDetail(nickname);
        memberDetailRepository.save(memberDetail);
        //when
        MemberDetail findmMemberDetail=memberDetailRepository.findOne(nickname);

        //then
        Assertions.assertThat(memberDetail.getNickname()).isEqualTo(findmMemberDetail.getNickname());
    }
}
