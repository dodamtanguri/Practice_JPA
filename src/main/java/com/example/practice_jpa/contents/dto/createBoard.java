package com.example.practice_jpa.contents.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class createBoard {
    @Pattern(regexp = "^[ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9\\s]+$", message = "게시물 제목은 한글, 숫자, 영문만 가능합니다.")
    @NotBlank(message = "게시물 제목은 필수로 입력 해야 합니다.")
    @Length(max = 50, message = "게시물 제목은 50자 이내 입니다.")
    @ApiModelProperty(value = "게시물 제목", example = "시각예술 작가로 부터 온 최소한의 작품")
    private String title;


    @NotBlank(message = "게시물 내용은 필수로 입력 해야 합니다.")
    @ApiModelProperty(value = "게시물", example = "여백이나 그림들이 들어있는 하나의 통일된 형태의 낱장들을 모아서 한쪽을 묶어 놓은 것' 으로 정의되고 있습니다.")
    private String content;

    @Pattern(regexp = "^[가-힣a-zA-Z_]+$", message = "작성자 이름은 한글, 숫자, 영문, _만 가능합니다.")
    @NotBlank(message = "작성자 이름은 필수로 입력 해야 합니다.")
    @Length(max = 20, message = "작성자 이름은 20자 이내입니다.")
    @ApiModelProperty(value = "작성자 이름", example = "dodam")
    private String writerName;

    @Email(message = "이메일 형식에 맞지 않습니다.")
    @ApiModelProperty(value = "작성자 이메일", example = "hellomwa.kr@gmail.com")
    private String writerEmail;



}
