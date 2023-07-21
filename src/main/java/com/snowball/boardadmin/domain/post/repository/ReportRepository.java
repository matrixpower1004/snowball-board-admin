package com.snowball.boardadmin.domain.post.repository;

import com.snowball.boardadmin.common.dto.PageRequestDto;
import com.snowball.boardadmin.domain.post.dto.ReportResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * author         : Jason Lee
 * date           : 2023-07-12
 * description    :
 */
@Mapper
public interface ReportRepository {

    List<ReportResponseDto> findAll();
    int deleteByPostId(Long postId);
    int countByDistinct();
    Long findByMaxReportId();
    List<ReportResponseDto> findByOption(PageRequestDto pageRequestDto);

    int count();

}
