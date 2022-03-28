package com.example.practice_jpa.contents.controller;

import com.example.practice_jpa.common.exception.CustomRequestException;
import com.example.practice_jpa.contents.service.BoardService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Board")
@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardService service;

    @ApiOperation(value = "게시물 리스트")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "페이지 번호", defaultValue = "1"),
            @ApiImplicitParam(name = "direction", dataType = "string", paramType = "query", value = "정렬기준", defaultValue = "ASC"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "페이지 사이즈", defaultValue = "10"),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "정렬 기준 : 등록일 순(start Date) 최근 순 (")})
    @ApiResponses( {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request", response = CustomRequestException.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = CustomRequestException.class)
    })
    @GetMapping
    public ResponseEntity<?> boardList(final CustomReq req) {
        return ResponseEntity.ok().body(service.getBoardList(req.of()));
    }


}
