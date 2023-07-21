package com.snowball.boardadmin.domain.admin.controller;

import com.snowball.boardadmin.common.dto.SearchDto;
import com.snowball.boardadmin.common.pagination.Page;
import com.snowball.boardadmin.common.pagination.Pageable;
import com.snowball.boardadmin.domain.admin.service.AdminService;
import com.snowball.boardadmin.domain.post.dto.PostResponseDto;
import com.snowball.boardadmin.domain.post.dto.ReportResponseDto;
import com.snowball.boardadmin.domain.user.dto.UserResponseDto;
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
        Page<UserResponseDto> pages = adminService.getUserList(pageable, searchDto);

        model.addAttribute("users", pages.getContent());
        model.addAttribute("pages", pages.getPageImpl());
        model.addAttribute("search", searchDto);

        return "/admin/userlist";
    }

    @GetMapping("report-list")
    public String reportList(Pageable pageable, SearchDto searchDto, Model model) {
        Page<ReportResponseDto> pages = adminService.getReportList(pageable, searchDto);

        model.addAttribute("reports", pages.getContent());
        model.addAttribute("pages", pages.getPageImpl());
        model.addAttribute("search", searchDto);

        return "/admin/reportlist";
    }

    @GetMapping("/post-list")
    public String postList(Pageable pageable, SearchDto searchDto, Model model) {
        Page<PostResponseDto> pages = adminService.getPostList(pageable, searchDto);

        model.addAttribute("posts", pages.getContent());
        model.addAttribute("pages", pages.getPageImpl());
        model.addAttribute("search", searchDto);

        return "/admin/postlist";
    }

}
