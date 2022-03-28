package com.example.practice_jpa.contents.service;

import com.example.practice_jpa.contents.dto.BoardDto;
import com.example.practice_jpa.contents.repository.BoardRepository;
import com.example.practice_jpa.contents.repository.BoardRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepositorySupport boardRepositorySupport;
    private final BoardRepository boardRepository;

    @Transactional
    public Page<BoardDto> getBoardList(final Pageable pageable){
        return boardRepositorySupport.getBoardList(pageable);
    }
}
