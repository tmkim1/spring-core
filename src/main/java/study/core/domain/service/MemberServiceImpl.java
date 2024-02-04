package study.core.domain.service;

import study.core.domain.entity.Member;
import study.core.domain.repository.MemberRepository;
import study.core.domain.repository.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    //직접 Impl 객체를 생성하지 말고, 생성자를 통해 주입 받자. (생성자 주입)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMemeber(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
