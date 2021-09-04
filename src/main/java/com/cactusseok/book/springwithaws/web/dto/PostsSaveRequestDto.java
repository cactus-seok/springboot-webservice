package com.cactusseok.book.springwithaws.web.dto;

import com.cactusseok.book.springwithaws.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
            .title(title)
            .content(content)
            .author(author)
            .build();
    }
}

/*
절대로 Entity 클래스를 Request/Response 클로스로 직접 사용해서는 안됩니다.
Entity는 DB와 맞닿은 핵심 클래스 이므로 Dto를 활용하여 자주 변경해도 문제가 없도록
Dto를 활용하도록 해야합니다.
 */
