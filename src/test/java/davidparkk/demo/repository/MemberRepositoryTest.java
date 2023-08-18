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

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    //@Rollback(false)
    public void saveTest() throws Exception{
        //given
            Member member=new Member("풀뚜껑먹어라","7VJVqyqgvJ4WXiRafcaQMRIRJkIywU7FAe8FTrrlp2AemwVZVSb0BVn6C9xA9JG1HG6azgW2jiL13w","naver.com");
            memberRepository.save(member);

        //when
            Member findMember=memberRepository.findOne("풀뚜껑먹어라");
        //then
        Assertions.assertThat(findMember).isSameAs(member);
    }

    @Test
    @Transactional
    //@Rollback(false)
    public void deleteTest() throws Exception {
        //given
        Member member=new Member("풀뚜껑먹어라","7VJVqyqgvJ4WXiRafcaQMRIRJkIywU7FAe8FTrrlp2AemwVZVSb0BVn6C9xA9JG1HG6azgW2jiL13w","naver.com");
        memberRepository.save(member);

        //when
        memberRepository.deleteByNickname(member.getNickname());
        Member findMember=memberRepository.findOne("풀뚜껑먹어라");
        //then
        Assertions.assertThat(findMember).isNull();
    }

    @Test
    @Transactional
    //@Rollback(false)
    public void findAllTest() throws Exception {
        //given
        Member member1=new Member("풀뚜껑먹어라","7VJVqyqgvJ4WXiRafcaQMRIRJkIywU7FAe8FTrrlp2AemwVZVSb0BVn6C9xA9JG1HG6azgW2jiL13w","naver.com");
        memberRepository.save(member1);

        Member member2=new Member("오마넌주세요","7VJVqyqgvJ4WXiRafcaQMRIRJkIywU7FAe8FTrrlp2AemwVZVSb0BVn6C9xA9JG1HG6azgW2jiL13w","naver.com");
        memberRepository.save(member2);

        //when
        List<Member> members=memberRepository.findALl();
        //then
        for (Member member : members) {
            System.out.println("member: "+member.getNickname());
        }

    }
}