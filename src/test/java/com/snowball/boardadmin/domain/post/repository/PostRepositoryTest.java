package com.snowball.boardadmin.domain.post.repository;

import com.snowball.boardadmin.common.dto.SearchDto;
import com.snowball.boardadmin.domain.post.dto.PostStateUpdateDto;
import com.snowball.boardadmin.domain.user.dto.UserStatisticsDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

/**
 * author         : Jason Lee
 * date           : 2023-07-14
 * description    :
 */
@MybatisTest
@AutoConfigureTestDatabase(replace= NONE)
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;



    @DisplayName("게시글 블라인드 상태 변경 테스트")
    @Test
    void postState_Update_Success_Test() {
        // Given
        PostStateUpdateDto postStateUpdateDto = PostStateUpdateDto.of(1L, true);

        // When
        int result = postRepository.saveState(postStateUpdateDto);

        // Then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("게시글 삭제 테스트")
    @Test
    void postDelete_Success_Test() {
        // Given
        Long id = 1L;

        // When
        int result = postRepository.delete(id);

        // Then
        assertThat(result).isEqualTo(1);
    }

}
