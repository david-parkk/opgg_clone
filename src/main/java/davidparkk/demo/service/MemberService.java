package davidparkk.demo.service;

import davidparkk.demo.domain.members.Member;
import davidparkk.demo.repository.MemberRepository;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import java.net.http.HttpClient;
//import java.net.http.HttpHeaders;

@Service
@Transactional(readOnly = true)
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public void addMember(String nickname){


        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add();

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Riot-Token","RGAPI-2ec95b11-4ede-40fb-bf47-2df753769e59");

        //RestTemplate restTemplate
    }
}
