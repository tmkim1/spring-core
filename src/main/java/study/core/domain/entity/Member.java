package study.core.domain.entity;

import lombok.Getter;
import lombok.ToString;
import study.core.domain.valueobject.Grade;

@Getter
@ToString
public class Member {
    private Long id;
    private String name;
    private Grade grade;

    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
}



