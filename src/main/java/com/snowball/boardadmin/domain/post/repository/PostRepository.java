package com.snowball.boardadmin.domain.post.repository;

import com.snowball.boardadmin.common.dto.PageRequestDto;
import com.snowball.boardadmin.common.dto.SearchDto;
import com.snowball.boardadmin.domain.post.dto.PostResponseDto;
import com.snowball.boardadmin.domain.post.dto.PostStateUpdateDto;
import com.snowball.boardadmin.domain.user.dto.UserStatisticsDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * author         : Jason Lee
 * date           : 2023-07-14
 * description    :
 */
@Mapper
public interface PostRepository {

    int saveState(PostStateUpdateDto postStateUpdateDto);
    int delete(Long id);

    int count();

    int countByOption(PageRequestDto pageRequestDto);

    List<PostResponseDto> findByOption(PageRequestDto pageRequestDto);

}
