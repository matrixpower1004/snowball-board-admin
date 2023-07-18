package com.snowball.boardadmin.domain.board.dto;

/**
 * author         : Jason Lee
 * date           : 2023-07-15
 * description    :
 */
public record BoardStateUpdateDto(
        Long id,
        boolean blind_state
) {

        public static BoardStateUpdateDto of(
                Long id,
                boolean blind_state
        ) {
            return new BoardStateUpdateDto(
                    id,
                    blind_state
            );
        }
}
