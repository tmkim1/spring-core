package study.core.domain.repository;

import study.core.domain.entity.Member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
