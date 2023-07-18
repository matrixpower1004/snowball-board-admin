package com.snowball.boardadmin.domain.user.repository;

import com.snowball.boardadmin.common.util.CustomPage;
import com.snowball.boardadmin.domain.user.dto.UserResponseDto;
import com.snowball.boardadmin.domain.user.dto.UserRequestDto;
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

    int searchResultCount(CustomPage pagination);

    List<UserResponseDto> searchResultList(CustomPage pagination);

}
