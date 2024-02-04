package study.core.domain.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.core.AppConfig;
import study.core.domain.entity.Member;
import study.core.domain.entity.Order;
import study.core.domain.valueobject.Grade;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void initService() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}