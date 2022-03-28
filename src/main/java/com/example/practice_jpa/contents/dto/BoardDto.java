package com.example.practice_jpa.contents.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BoardDto {
    @ApiModelProperty(value = "게시글 제목", example = "도담이는 세상에서 제일 귀여운 고먐미")
    private String title;
    @ApiModelProperty(value = "게시글 작성자", example = "도담이집사")
    private String writer;
    @ApiModelProperty(value = "게시글 내용", example = "도담이는 너무 귀여워요 자랑하고 싶어서 글 작성해요~")
    private String content;
    @ApiModelProperty(value = "게시글 상태", example = "공개 public/ 비공개 private")
    private String status;
    @ApiModelProperty(value = "게시물 등록일", example = "2022-03-02")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;
    @ApiModelProperty(value = "게시물 수정일", example = "2022-03-28")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifyDate;
}
