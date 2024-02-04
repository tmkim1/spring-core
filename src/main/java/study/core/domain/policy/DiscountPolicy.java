package study.core.domain.policy;

import study.core.domain.entity.Member;

/**
 * return 할인 금액
 */
public interface DiscountPolicy {
    int discount(Member member, int price);
}
