package davidparkk.demo.service;


import davidparkk.demo.domain.members.MemberDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberDetailServiceTest {

    @Autowired
    MemberDetailService memberDetailService;

    @Test
    @Transactional
    @Rollback(false)
    public  void addmembertest(){
        String nickanme="풀뚜껑먹어라";
       // MemberDetail memberDetail=new MemberDetail(nickanme);
        memberDetailService.addMember(nickanme);
    }
}
