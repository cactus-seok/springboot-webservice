package com.cactusseok.book.springwithaws.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

}

/*
@MappedSuperclass : JPA Entity 클래스들이 BaseTimeEntity을 상속할 경우 필드들도
컬럼으로 인식하게 합니다.
@EntityListeners(AuditingEntityListener.class) : BaseTimeEntity 클래스에 Auditing 기능을
포함시킵니다.


 */