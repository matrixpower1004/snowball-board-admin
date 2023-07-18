package com.snowball.boardadmin.domain.board.repository;

import com.snowball.boardadmin.domain.board.dto.ReportRequestDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

/**
 * author         : Jason Lee
 * date           : 2023-07-16
 * description    :
 */
@MybatisTest
@AutoConfigureTestDatabase(replace= NONE)
class ReportBoardRepositoryTest {

    @Autowired
    private ReportBoardRepository reportBoardRepository;

    @DisplayName("신고게시판 목록 조회 테스트")
    @Test
    void reportBoard_Select_Test() {
        // Given


        // When
        List<ReportRequestDto> reportRequestDtos = reportBoardRepository.findAll();
        System.out.println("size : " + reportRequestDtos.size());

        // Then
        Assertions.assertThat(reportRequestDtos).isNotNull();
    }

    @DisplayName("신고게시판 게시글 삭제 테스트")
    @Test
    void reportBoard_delete_test() {
        // Given
        // 가장 많이 신고가 된 게시글의 id를 가져와서 삭제를 한다.
        Long postId = reportBoardRepository.findByMaxReportId();

        // When
        int result = reportBoardRepository.deleteByPostId(postId);

        // Then
        assertThat(result).isGreaterThan(1);
    }

    @DisplayName("게시판 페이징을 위해 신고된 게시글의 중복을 제외한 카운트를 가져온다.")
    @Test
    void reportBoard_countByDistinct_test() {
        // Given
        int countAll = reportBoardRepository.count();
        int countDistinct = reportBoardRepository.countByDistinct();
        System.out.println("countAll = " + countAll);
        System.out.println("countDistinct = " + countDistinct);

        // When & Then
        assertThat(countAll).isGreaterThan(countDistinct);
    }

    @Test
    void test() {
    }

}
