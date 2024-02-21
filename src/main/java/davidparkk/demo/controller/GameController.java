package davidparkk.demo.controller;


import davidparkk.demo.service.GameService;
import davidparkk.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GameController {

    private final MemberService memberService;
    private final GameService gameService;
    @PostMapping("/add")
    public String add(@RequestParam("summoner")String summoner) {
        memberService.addMember(summoner);
        return "success";
    }

    @PostMapping("/update")
    public String update(@RequestParam("summoner")String summoner) {
        gameService.updateMemberInfo(summoner);
        return "success";
    }

}
