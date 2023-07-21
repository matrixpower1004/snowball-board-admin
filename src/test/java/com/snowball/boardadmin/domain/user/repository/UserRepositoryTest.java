package com.snowball.boardadmin.domain.user.repository;

import com.snowball.boardadmin.common.dto.PageRequestDto;
import com.snowball.boardadmin.common.dto.SearchDto;
import com.snowball.boardadmin.common.pagination.Pageable;
import com.snowball.boardadmin.common.util.UserRole;
import com.snowball.boardadmin.domain.user.dto.UserResponseDto;
import com.snowball.boardadmin.domain.user.dto.UserStatisticsDto;
import com.snowball.boardadmin.domain.user.dto.UserUpdateDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;
import java.util.function.BiFunction;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

/**
 * author         : Jason Lee
 * date           : 2023-07-14
 * description    :
 */
@MybatisTest
@AutoConfigureTestDatabase(replace= NONE)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @DisplayName("유저 권한 수정 테스트")
    @Test
    void userRoleUpdate_Success_Test() {
        // Given
        UserUpdateDto userUpdateDto = UserUpdateDto.of(1L, UserRole.EXPERT);

        // When
        int result = userRepository.updateUserRole(userUpdateDto);

        // Then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("전체 유저 조회 테스트")
    @Test
    void userResponseDto_Success_Test() {
        // Given
        List<UserResponseDto> result = userRepository.findAll();

        // When & Then
        System.out.println(result);
        assertThat(result).isNotNull();
    }

    @Test
    void count_test() {
        // Given
        int result = userRepository.count();
        System.out.println("result : " + result);

        // When & Then
        assertThat(result).isGreaterThan(1);
    }

    @DisplayName("게시글 통계 조회 : 댓글 많은 유저순 정렬 테스트")
    @Test
    void findPostStatistics_OrderByComment_Success_Test() {
        // Given
        PageRequestDto pageRequestDto = getPageRequest("comment");
        List<UserStatisticsDto> statistics = userRepository.findStatistics(pageRequestDto);

        // When
        int commentCount0 = statistics.get(0).commentCount();
        int commentCount1 = statistics.get(1).commentCount();

        // Then
        // 첫 게시글의 댓글 갯수가 두번째 게시글의 댓글 갯수보다 많거나 같다.
        assertTrue(commentCount0 >= commentCount1);
    }

    @DisplayName("게시글 통계 조회 : 대댓글 많은 유저순 정렬 테스트")
    @Test
    void findPostStatistics_OrderByReply_Success_Test() {
        // Given
        PageRequestDto pageRequestDto = getPageRequest("reply");
        List<UserStatisticsDto> statistics = userRepository.findStatistics(pageRequestDto);

        // When
        int replyCount0 = statistics.get(0).replyCount();
        int replyCount1 = statistics.get(1).replyCount();

        // Then
        // 첫 게시물의 대댓글 갯수가 두번째 게시물의 대댓글 갯수보다 많거나 같다.
        assertTrue(replyCount0 >= replyCount1);
    }

    @DisplayName("게시글 통계 조회 : 게시글 많은 유저순 정렬 테스트")
    @Test
    void findPostStatistics_OrderByPost_Success_Test() {
        // Given
        PageRequestDto pageRequestDto = getPageRequest("post");
        List<UserStatisticsDto> statistics = userRepository.findStatistics(pageRequestDto);

        // When
        int postCount0 = statistics.get(0).postCount();
        int postCount1 = statistics.get(0).postCount();

        // Then
        // 첫 게시글의 갯수가 두번째 게시글의 갯수보다 많거나 같다.
        assertTrue(postCount0 >= postCount1);
    }

    private PageRequestDto getPageRequest(String option){
        SearchDto searchDto = SearchDto.of(option, "");
        Pageable pageable = new Pageable(1, 10);
        return PageRequestDto.from(pageable, searchDto);
    }

}
