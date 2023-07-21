package com.snowball.boardadmin.domain.admin.service;

import com.snowball.boardadmin.common.dto.PageRequestDto;
import com.snowball.boardadmin.common.dto.SearchDto;
import com.snowball.boardadmin.common.pagination.Page;
import com.snowball.boardadmin.common.pagination.PageImpl;
import com.snowball.boardadmin.common.pagination.Pageable;
import com.snowball.boardadmin.domain.post.dto.PostResponseDto;
import com.snowball.boardadmin.domain.post.dto.ReportResponseDto;
import com.snowball.boardadmin.domain.post.repository.PostRepository;
import com.snowball.boardadmin.domain.post.repository.ReportRepository;
import com.snowball.boardadmin.domain.user.dto.UserResponseDto;
import com.snowball.boardadmin.domain.user.dto.UserStatisticsDto;
import com.snowball.boardadmin.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 * author         : Jason Lee
 * date           : 2023-07-17
 * description    :
 */
@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;
    private final ReportRepository reportRepository;
    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public Page<UserResponseDto> getUserList(Pageable pageable, SearchDto searchDto) {

        PageRequestDto pageRequestDto = PageRequestDto.from(pageable, searchDto);

        // 페이징을 하기 위해 검색 조건에 맞는 전체 레코드 수를 구한다.
        int count = userRepository.countByOption(pageRequestDto);

        // 조건에 해당하는 데이터가 없다면, 빈 리스트를 반환한다.
        checkCount.apply(count);

        // 페이지 정보 계산 후 Pagination 객체 생성
        PageImpl pagination = new PageImpl(pageable, count);

        List<UserResponseDto> userLists = userRepository.findByOption(pageRequestDto);
        return new Page<>(userLists, pagination);
    }

    @Transactional(readOnly = true)
    public Page<ReportResponseDto> getReportList(Pageable pageable, SearchDto searchDto) {

        PageRequestDto pageRequestDto = PageRequestDto.from(pageable, searchDto);

        int count = reportRepository.countByDistinct();
        checkCount.apply(count);

        PageImpl pagination = new PageImpl(pageable, count);

        List<ReportResponseDto> reportLists = reportRepository.findByOption(pageRequestDto);
        return new Page<>(reportLists, pagination);
    }

    @Transactional(readOnly = true)
    public Page<PostResponseDto> getPostList(Pageable pageable, SearchDto searchDto) {

        PageRequestDto pageRequestDto = PageRequestDto.from(pageable, searchDto);

        int count = postRepository.countByOption(pageRequestDto);
        checkCount.apply(count);

        PageImpl pagination = new PageImpl(pageable, count);

        List<PostResponseDto> postLists = postRepository.findByOption(pageRequestDto);
        return new Page<>(postLists, pagination);
    }

    @Transactional(readOnly = true)
    public Page<UserStatisticsDto> getUserStatistics(Pageable pageable, SearchDto searchDto) {

        PageRequestDto pageRequestDto = PageRequestDto.from(pageable, searchDto);

        int count = userRepository.countByOption(pageRequestDto);
        System.out.println("count = " + count);
        checkCount.apply(count);

        PageImpl pagination = new PageImpl(pageable, count);

        List<UserStatisticsDto> userStatistics = userRepository.findStatistics(pageRequestDto);
        return new Page<>(userStatistics, pagination);
    }

    private final Function<Integer, Page> checkCount = (count) -> {
        if (count < 1) {
            return new Page<>(Collections.emptyList(), null);
        }
        return null;
    };

}
