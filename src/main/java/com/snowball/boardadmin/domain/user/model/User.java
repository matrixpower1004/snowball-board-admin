package com.snowball.boardadmin.domain.user.model;

import com.snowball.boardadmin.common.util.UserRole;
import lombok.*;

import java.sql.Timestamp;
/**
 * author         : Jason Lee
 * date           : 2023-07-13
 * description    :
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class User {

    private Long id;
    // 유저의 Unique ID (로그인 ID)
    private String userAccount;
    private String userName;
    private String password;
    private String email;
    private String nickName;
    // TRUE(Activated), FALSE(UnActivated)
    private Boolean userStatus;
    // 회원의 등급
    private UserRole userRole;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
