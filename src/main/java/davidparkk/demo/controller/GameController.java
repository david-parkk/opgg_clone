package davidparkk.demo.controller;


import davidparkk.demo.service.GameService;
import davidparkk.demo.service.MatchingService;
import davidparkk.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GameController {

    private final MemberService memberService;
    private final GameService gameService;
    private final MatchingService matchingService;

    @PostMapping("/add")
    public String add(@RequestParam("summoner") String summoner) {
        memberService.addMember(summoner);
        return "success";
    }

    @PostMapping("/update")
    public String update(@RequestParam("summoner") String summoner, @RequestParam(value = "count", defaultValue = "5") int count) {
        String puuidBySummoner = memberService.getPuuidBySummoner(summoner);
        List<String> validMatching = matchingService.getValidMatching(matchingService.getMatchingByMember(puuidBySummoner, count));
        validMatching.stream()
                .forEach(m -> gameService.updateMemberInfo(m));
        validMatching.stream()
                .forEach(m -> matchingService.saveByMatchingId(m));

        return "success";
    }

}
