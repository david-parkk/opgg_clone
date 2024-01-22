package davidparkk.demo.service;


import davidparkk.demo.domain.members.Member;
import davidparkk.demo.domain.members.MemberDetail;
import davidparkk.demo.domain.members.MemberPlay;
import davidparkk.demo.domain.riotApi.Summoner;
import davidparkk.demo.repository.MemberDetailRepository;
import davidparkk.demo.repository.MemberRepository;
import davidparkk.demo.riotApi.RiotApiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.Id;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberDetailService {



}
