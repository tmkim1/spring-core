package study.core.domain.service;

import study.core.domain.entity.Member;

public interface MemberService {
    void join(Member member);

    Member findMemeber(Long memberId);
}