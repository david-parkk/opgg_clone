package davidparkk.demo.repository;

import davidparkk.demo.domain.Match;
import org.assertj.core.api.Assertions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MatchRepositoryTest {

    @Autowired
    MatchRepository matchRepository;


    @Test
    @Transactional
    //@Rollback(false)
    public void testMatch1(){
        //given
        String id ="asdf1";
        Match match=new Match(id);

        //when
        matchRepository.save(match);
        Match findmatch=matchRepository.findOne(id);
        //then
        System.out.println("result: "+findmatch.getId());


    }

    @Test//(expected = NullPointerException.class)
    @Transactional
    //@Rollback(false)
    public void testMatch2(){
        //given
        String id ="asdf1";
        Match match=new Match(id);

        //when
        matchRepository.save(match);
        //then
        Match findmatch = matchRepository.findOne("asdf");
        Assertions.assertThat(findmatch).isNull();


    }

}