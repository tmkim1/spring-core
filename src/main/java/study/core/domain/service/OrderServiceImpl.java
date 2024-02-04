package study.core.domain.service;

import org.springframework.stereotype.Service;
import study.core.domain.entity.Member;
import study.core.domain.entity.Order;
import study.core.domain.policy.DiscountPolicy;
import study.core.domain.repository.MemberRepository;

@Service
public class OrderServiceImpl implements OrderService{

    //구현 클래스에도 의존하고 있는 DIP 위반! 상태 -> 추상에만 의존하도록 변경해야한다.
    //FixDiscountPolicu -> RateDiscountPolicy로 변경하게 되면 OrderServiceImpl 클래스 변경이 필요함 OCP 위반!
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
