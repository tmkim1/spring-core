package study.core.domain.policy;

import study.core.domain.entity.Member;
import study.core.domain.valueobject.Grade;

import java.util.Objects;

public class FixDiscountPolicy implements DiscountPolicy{

    private final int fixedDiscountAmount = 1000;

    @Override
    public int discount(Member member, int price) {

        //enum에 대한 값 비교는 "=="를 사용한다.
        if(member.getGrade() == Grade.VIP) {
            return fixedDiscountAmount;
        } else {
            return 0;
        }
    }

}
