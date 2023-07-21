package com.snowball.boardadmin.domain.user.service;

import com.snowball.boardadmin.domain.user.dto.UserUpdateDto;
import com.snowball.boardadmin.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * author         : Jason Lee
 * date           : 2023-07-14
 * description    :
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void updateUserRole(UserUpdateDto userUpdateDto) {
        int result = userRepository.updateUserRole(userUpdateDto);
    }

}
