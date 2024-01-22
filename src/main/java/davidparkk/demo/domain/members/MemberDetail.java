package davidparkk.demo.domain.members;

import davidparkk.demo.domain.riotApi.Participant;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class MemberDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "kills")
    private int kill;

    private int death;
    private int damage;
    private int damagedTaken;

    @OneToOne(mappedBy = "memberDetail", fetch = FetchType.LAZY)
    private Member member;

    public MemberDetail(){
        this.kill=0;
        this.death=0;
        this.damage=0;
        this.damagedTaken=0;
    }
    public MemberDetail(Member member){
        this.member=member;
        this.kill=0;
        this.death=0;
        this.damage=0;
        this.damagedTaken=0;
    }

    public void update(Participant participant){
        this.kill+=participant.getKill();
        this.death+=participant.getDeath();
        this.damage+=participant.getDamage();
        this.damagedTaken+=participant.getDamageTaken();

    }
}
