package com.cactusseok.book.springwithaws.service.posts;

import com.cactusseok.book.springwithaws.domain.posts.Posts;
import com.cactusseok.book.springwithaws.domain.posts.PostsRepository;
import com.cactusseok.book.springwithaws.web.dto.PostsListResponseDto;
import com.cactusseok.book.springwithaws.web.dto.PostsResponseDto;
import com.cactusseok.book.springwithaws.web.dto.PostsSaveRequestDto;
import com.cactusseok.book.springwithaws.web.dto.PostsUpdateRequestDto;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id)
        );
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }


    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id)
        );

        return new PostsResponseDto(entity);
    }

    @Transactional
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
            .map(PostsListResponseDto::new)
            .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        postsRepository.delete(posts);
    }
}

/*
@Autowired 가 없는것이 어색하게 느껴질수도 있다. Bean을 주입받는 방식중에 가장
권장하는 방식은 생성자로 주입받는 방식입니다. 즉, 위의 코드에서 생성자는 롬복의
@RequiredArgsConstructor가 해결해 줍니다. final이 선언된 모든 필드를 인자값으로 하는
생성자를 롬복이 대신 생성해 준 것입니다. 생성자를 직접 안 쓰고 롬복 어노테이션을 사용한 이유는
해당 클래스의 의존성 관계가 변경될 때마다 생성자 코드를 계속해서 수정하는 번거로움을 해결하기 위함.
 */
