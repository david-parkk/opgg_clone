package davidparkk.demo.repository;

import davidparkk.demo.domain.members.Member;
import org.assertj.core.api.Assertions;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class memberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testMember() throws Exception{
        //given
            Member member=new Member("풀뚜껑먹어라","7VJVqyqgvJ4WXiRafcaQMRIRJkIywU7FAe8FTrrlp2AemwVZVSb0BVn6C9xA9JG1HG6azgW2jiL13w","naver.com");
            memberRepository.save(member);

        //when
            Member findMember=memberRepository.findOne("풀뚜껑먹어라");
        //then
        Assertions.assertThat(findMember).isSameAs(member);
    }
}