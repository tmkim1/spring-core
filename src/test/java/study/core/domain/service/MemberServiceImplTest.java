package study.core.domain.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.core.AppConfig;
import study.core.domain.entity.Member;
import study.core.domain.valueobject.Grade;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceImplTest {

    MemberService memberService;

    @BeforeEach
    public void initService() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.BASIC);

        //when
        memberService.join(member);
        Member findMember = memberService.findMemeber(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}