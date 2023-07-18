package com.snowball.boardadmin.domain.board.model;

import com.snowball.boardadmin.common.util.UserRole;
import lombok.*;
import java.sql.Timestamp;
/**
 * author         : Jason Lee
 * date           : 2023-07-13
 * description    :
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Post {

    private Long id;
    private Long userId;
    private String title;
    private String content;
    private boolean blindState;
    private UserRole userRole;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
