package com.snowball.boardadmin.domain.post.model;

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
public class Comment {

    private Long id;
    private Long userId;
    private Long postId;
    private String content;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}