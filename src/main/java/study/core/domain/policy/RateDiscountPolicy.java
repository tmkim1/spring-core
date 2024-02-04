package study.core.domain.policy;

import study.core.domain.entity.Member;
import study.core.domain.valueobject.Grade;

public class RateDiscountPolicy implements DiscountPolicy{

    private final int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (Grade.VIP == member.getGrade()) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
