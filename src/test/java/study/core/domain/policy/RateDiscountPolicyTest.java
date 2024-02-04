package study.core.domain.policy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.core.domain.entity.Member;
import study.core.domain.valueobject.Grade;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void discount_for_vip() {
        //given
        int itemPrice = 10000;
        int expectedDiscountPrice = 10000/10;

        Member member = new Member(1L, "member1", Grade.VIP);

        //when
        int discountedPrice = discountPolicy.discount(member, itemPrice);

        //then
        assertThat(discountedPrice).isEqualTo(expectedDiscountPrice);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않는다.")
    void discount_not_in_target() {
        //given
        int itemPrice = 10000;

        Member member = new Member(1L, "member1", Grade.BASIC);

        //when
        int discountedPrice = discountPolicy.discount(member, itemPrice);

        //then
        assertThat(discountedPrice).isEqualTo(0);
    }

}