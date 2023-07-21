package com.snowball.boardadmin.domain.board.repository;

import com.snowball.boardadmin.common.dto.PageRequestDto;
import com.snowball.boardadmin.domain.board.dto.ReportRequestDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * author         : Jason Lee
 * date           : 2023-07-12
 * description    :
 */
@Mapper
public interface ReportBoardRepository {

    List<ReportRequestDto> findAll();
    int deleteByPostId(Long postId);
    int countByDistinct();
    Long findByMaxReportId();
    List<ReportRequestDto> searchResultList(PageRequestDto pageRequestDto);

    int count();

}
