package davidparkk.demo.riotApi;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RiotApiTest {


    @Test
    @Transactional
    @Rollback(false)

    public void RiotApiTest1(){



    }
}
