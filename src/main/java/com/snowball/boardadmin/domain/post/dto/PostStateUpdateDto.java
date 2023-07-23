package com.snowball.boardadmin.domain.post.dto;

/**
 * author         : Jason Lee
 * date           : 2023-07-15
 * description    :
 */
public record PostStateUpdateDto(
        Long id,
        boolean blind_state
) {

        public static PostStateUpdateDto of(
                Long id,
                boolean blind_state
        ) {
            return new PostStateUpdateDto(
                    id,
                    blind_state
            );
        }
}
