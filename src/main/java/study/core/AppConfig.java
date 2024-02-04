package study.core;

import study.core.domain.policy.FixDiscountPolicy;
import study.core.domain.repository.MemoryMemberRepository;
import study.core.domain.service.MemberService;
import study.core.domain.service.MemberServiceImpl;
import study.core.domain.service.OrderService;
import study.core.domain.service.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}

