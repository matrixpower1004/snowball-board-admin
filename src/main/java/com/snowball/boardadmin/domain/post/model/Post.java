package com.snowball.boardadmin.domain.post.model;

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
    private UserRole title;
    private UserRole content;
    private Boolean blindState;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
