package study.core;

import study.core.domain.entity.Member;
import study.core.domain.repository.MemberRepository;
import study.core.domain.service.MemberService;
import study.core.domain.service.MemberServiceImpl;
import study.core.domain.valueobject.Grade;

public class MemberApp {
    public static void main(String[] args) {

        //Interface인 MemberSerivce에도 의존하고, MemberServiceImpl 구현부도 의존하고 있는 좋지 않은 상태
//        MemberService memberService = new MemberServiceImpl();

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L, "taemin", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMemeber(1L);

        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
