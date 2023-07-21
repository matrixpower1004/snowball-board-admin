package com.snowball.boardadmin.domain.user.repository;

import com.snowball.boardadmin.common.util.UserRole;
import com.snowball.boardadmin.domain.user.dto.UserResponseDto;
import com.snowball.boardadmin.domain.user.dto.UserUpdateDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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

}
