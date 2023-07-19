package com.snowball.boardadmin.domain.user.repository;

import com.snowball.boardadmin.common.dto.PageRequestDto;
import com.snowball.boardadmin.domain.user.dto.UserRequestDto;
import com.snowball.boardadmin.domain.user.dto.UserResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * author         : Jason Lee
 * date           : 2023-07-14
 * description    :
 */
@Mapper
public interface UserRepository {
    int updateUserRole(UserRequestDto userRequestDto);

    List<UserResponseDto> findAll();

    int count();

    int searchResultCount(PageRequestDto pageRequestDto);

    List<UserResponseDto> searchResultList(PageRequestDto pageRequestDto);

}
