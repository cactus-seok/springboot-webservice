package com.cactusseok.book.springwithaws.domain.posts;

import com.cactusseok.book.springwithaws.domain.BaseTimeEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // 해당 클래스의 빌더 패턴 클래스를 생성
@NoArgsConstructor // 기본 생성자 자동 추가
@Entity // 테이블과 링크될 클래스임을 나타냅니다.
public class Posts extends BaseTimeEntity {

    @Id // 해당 테이블의 PK필드를 나타냅니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

/*
위의 Posts클래스는 한가지 특이점이 있습니다. 바로 Setter 메소드가 없다는 점입니다.
자바빈 규약을 생각하면서 getter/setter를 무작정 생성하는 경우가 있습니다. 이렇게 되면 해당 클래스의
인스턴스 값들이 언제 어디서 변해야 하는지 코드상으로 명확하게 구분할 수가 없어, 차후 기능 변경 시 정말 복잡해집니다.
그래서 Entity 클래스에서는 절대 Setter 메소드를 만들지 않습니다. 대신, 해당 필드의 값 변경이 필요하면 명확히
그 목적과 의도를 나타낼 수 있는 메소드를 추가해야만 합니다.
 */
