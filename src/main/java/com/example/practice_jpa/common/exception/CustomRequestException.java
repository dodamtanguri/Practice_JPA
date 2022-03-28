package com.example.practice_jpa.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
@RequiredArgsConstructor
public enum CustomRequestException {
    NO_EXISTED_POST(BAD_REQUEST,"존재하지 않는 게시물입니다. ");
    private final HttpStatus status;
    private final String message;
}
