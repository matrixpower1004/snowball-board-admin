package com.snowball.boardadmin.domain.admin.controller;

import com.snowball.boardadmin.common.dto.SearchDto;
import com.snowball.boardadmin.common.pagination.Page;
import com.snowball.boardadmin.common.pagination.Pageable;
import com.snowball.boardadmin.domain.admin.service.AdminService;
import com.snowball.boardadmin.domain.post.dto.PostResponseDto;
import com.snowball.boardadmin.domain.post.dto.ReportResponseDto;
import com.snowball.boardadmin.domain.user.dto.UserResponseDto;
import com.snowball.boardadmin.domain.user.dto.UserStatisticsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author         : Jason Lee
 * date           : 2023-07-12
 * description    :
 */
@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/")
    public String adminIndex() {
        //todo: security 설정 완료되면 접근한 사용자의 권한이 admin이 아니면 예외 발생 시키기

        return "/admin/index";
    }

    @GetMapping("/user-list")
    public String userList(Pageable pageable, SearchDto searchDto, Model model) {
        Page<UserResponseDto> userResponse = adminService.getUserList(pageable, searchDto);

        model.addAttribute("users", userResponse.getContent());
        model.addAttribute("pages", userResponse.getPageImpl());
        model.addAttribute("search", searchDto);

        return "/admin/userlist";
    }

    @GetMapping("report-list")
    public String reportList(Pageable pageable, SearchDto searchDto, Model model) {
        Page<ReportResponseDto> reportList = adminService.getReportList(pageable, searchDto);

        model.addAttribute("reports", reportList.getContent());
        model.addAttribute("pages", reportList.getPageImpl());
        model.addAttribute("search", searchDto);

        return "/admin/reportlist";
    }

    @GetMapping("/post-list")
    public String postList(Pageable pageable, SearchDto searchDto, Model model) {
        Page<PostResponseDto> postList = adminService.getPostList(pageable, searchDto);

        model.addAttribute("posts", postList.getContent());
        model.addAttribute("pages", postList.getPageImpl());
        model.addAttribute("search", searchDto);

        return "/admin/postlist";
    }

    @GetMapping("/user-statistics")
    public String userStatistics(Pageable pageable, SearchDto searchDto, Model model) {
        Page<UserStatisticsDto> statistics = adminService.getUserStatistics(pageable, searchDto);

        model.addAttribute("statistics", statistics.getContent());
        model.addAttribute("pages", statistics.getPageImpl());
        model.addAttribute("search", searchDto);

        return "/admin/statistics";
    }

}
