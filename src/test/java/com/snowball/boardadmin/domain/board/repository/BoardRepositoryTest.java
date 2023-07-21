package com.snowball.boardadmin.domain.board.repository;

import com.snowball.boardadmin.domain.board.dto.BoardStateUpdateDto;
import com.snowball.boardadmin.domain.board.dto.BoardStatisticsDto;
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
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @DisplayName("게시판 통계 조회 : 댓글 많은 유저순 정렬 테스트")
    @Test
    void findBoardStatistics_OrderByComment_Success_Test() {
        // Given
        String order = "comment";
        List<BoardStatisticsDto> statistics = boardRepository.findStatistics(order);

        // When
        int commentCount0 = statistics.get(0).commentCount();
        int commentCount1 = statistics.get(1).commentCount();

        // Then
        // 첫 게시글의 댓글 갯수가 두번째 게시글의 댓글 갯수보다 많거나 같다.
        assertTrue(commentCount0 >= commentCount1);
    }

    @DisplayName("게시판 통계 조회 : 대댓글 많은 유저순 정렬 테스트")
    @Test
    void findBoardStatistics_OrderByReply_Success_Test() {
        // Given
        String order = "reply";
        List<BoardStatisticsDto> statistics = boardRepository.findStatistics(order);

        // When
        int replyCount0 = statistics.get(0).replyCount();
        int replyCount1 = statistics.get(1).replyCount();

        // Then
        // 첫 게시물의 대댓글 갯수가 두번째 게시물의 대댓글 갯수보다 많거나 같다.
        assertTrue(replyCount0 >= replyCount1);
    }

    @DisplayName("게시판 통계 조회 : 게시글 많은 유저순 정렬 테스트")
    @Test
    void findBoardStatistics_OrderByPost_Success_Test() {
        // Given
        String order = "post";
        List<BoardStatisticsDto> statistics = boardRepository.findStatistics(order);

        // When
        int postCount0 = statistics.get(0).postCount();
        int postCount1 = statistics.get(0).postCount();

        // Then
        // 첫 게시글의 갯수가 두번째 게시글의 갯수보다 많거나 같다.
        assertTrue(postCount0 >= postCount1);
    }

    @DisplayName("게시판 블라인드 상태 변경 테스트")
    @Test
    void boardState_Update_Success_Test() {
        // Given
        BoardStateUpdateDto boardStateUpdateDto = BoardStateUpdateDto.of(1L, true);

        // When
        int result = boardRepository.saveState(boardStateUpdateDto);

        // Then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("게시판 삭제 테스트")
    @Test
    void boardDelete_Success_Test() {
        // Given
        Long id = 1L;

        // When
        int result = boardRepository.delete(id);

        // Then
        assertThat(result).isEqualTo(1);
    }

}
