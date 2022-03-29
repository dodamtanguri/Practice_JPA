package com.example.practice_jpa.common.enmuns;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    SUCCESS(OK,"Success"),
    ERROR(INTERNAL_SERVER_ERROR, "Internal Server Error"),
    NO_EXISTED_POST(BAD_REQUEST,"존재하지 않는 게시물입니다.");

    private final HttpStatus status;
    private final String message;
}
