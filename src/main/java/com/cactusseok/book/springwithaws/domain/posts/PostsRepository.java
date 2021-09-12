package com.cactusseok.book.springwithaws.domain.posts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p order by p.id DESC")
    List<Posts> findAllDesc();

}

/**
 * 규모가 있는 데이터 조회는 FK의 조인, 복잡한 조건 등으로 인해 이런 Entity클래스만으로
 * 처리하기 어려워 조회용 프레임워크를 추가로 사용합니다. 대표적으로 Querydsl을 많이 사용하며,
 * 조회는 Querydsl을 사용하고 등록/수정/삭제는 SpringDataJpa를 통해 진행합니다.
 *
 * Querydsl의 장점
 * 1. 타입안정성이 보장됩니다.
 *  단순한 문자열로 쿼리를 생성하는 것이 아니라, 메소드를 기반으로 쿼리를 생성하기
 *  때문에 오타나 존재하지 않는 컬럼명을 명시할 경우 IDE에서 자동으로 검출됩니다.
 *
 * 2. 국내 많은 회사에서 사용 중입니다.
 *  쿠팡, 배민 등 JPA를 적극적으로 사용하는 회사에서는 Querydsl을 적극적으로 사용중입니다.
 *
 * 3. 레퍼런스가 많습니다.
 *  앞 2번의 장점에서 이어지는 것인데, 많은 회사와 개발자들이 사용하다보니 그만큼 국내자료가
 *  많습니다. 어떤 문제가 발생했을 때 여러 커뮤니티에 질문하고 그에 대한
 *  답변을 들을 수 있다는 것은 큰 장점입니다.
 */
