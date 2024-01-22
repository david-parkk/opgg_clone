package davidparkk.demo.service;

import davidparkk.demo.domain.members.MemberDetail;
import davidparkk.demo.domain.members.MemberPlay;
import davidparkk.demo.repository.MemberPlayRepository;
import davidparkk.demo.repository.MemberRepository;
import net.bytebuddy.asm.Advice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class MemberPlayServiceTest {


}