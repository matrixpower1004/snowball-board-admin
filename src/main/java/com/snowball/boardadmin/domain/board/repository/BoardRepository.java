package com.snowball.boardadmin.domain.board.repository;

import com.snowball.boardadmin.domain.board.dto.BoardStateUpdateDto;
import com.snowball.boardadmin.domain.board.dto.BoardStatisticsDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author         : Jason Lee
 * date           : 2023-07-14
 * description    :
 */
@Mapper
public interface BoardRepository {

    List<BoardStatisticsDto> findStatistics(@Param("order") String order);
    int saveState(BoardStateUpdateDto boardStateUpdateDto);
    int delete(Long id);

    int count();

}
