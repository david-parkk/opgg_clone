package davidparkk.demo.service;

import davidparkk.demo.domain.members.Member;
import davidparkk.demo.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Test
    @Transactional
    @Rollback(false)
    public void addMember() {
        String nickname="풀뚜껑먹어라";
        memberService.addMember(nickname);
        Member findMember=memberRepository.findOne(nickname);
        Assertions.assertThat(findMember.getNickname()).isEqualTo(nickname);
        Assertions.assertThat(findMember.getNickname()).isSameAs(nickname);
    }



    @Test
    @Transactional
    @Rollback(false)
    public void addMember2() {


        String nickname="풀뚜1껑먹어라";
        memberService.addMember(nickname);
        Member findMember=memberRepository.findOne(nickname);
        Assertions.assertThat(findMember).isNull();
    }
}