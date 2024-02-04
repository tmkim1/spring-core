package study.core;

import study.core.domain.entity.Member;
import study.core.domain.entity.Order;
import study.core.domain.service.MemberService;
import study.core.domain.service.MemberServiceImpl;
import study.core.domain.service.OrderService;
import study.core.domain.service.OrderServiceImpl;
import study.core.domain.valueobject.Grade;

public class OrderApp {
    public static void main(String[] args) {

//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "taemin", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "USB", 15000);
        System.out.println("order = " + order.toString());
        System.out.println("order calculatedPrice = " + order.calculatePrice());
    }
}
