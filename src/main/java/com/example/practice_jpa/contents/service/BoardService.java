package com.example.practice_jpa.contents.service;

import com.example.practice_jpa.contents.dto.BoardDto;
import com.example.practice_jpa.contents.dto.CreateBoard;
import com.example.practice_jpa.contents.model.Board;
import com.example.practice_jpa.contents.model.Writer;
import com.example.practice_jpa.contents.repository.BoardRepository;
import com.example.practice_jpa.contents.repository.BoardRepositorySupport;
import com.example.practice_jpa.contents.repository.WriterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

import static com.example.practice_jpa.common.exception.CustomRequestException.NO_EXISTED_POST;


@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardRepositorySupport boardRepositorySupport;
    private final WriterRepository writerRepository;


    public Page<BoardDto> getBoardList(final Pageable pageable) {
        return boardRepositorySupport.getBoardList(pageable);
    }

    public Object getBoardDetail(Long id) {
        return boardRepositorySupport.getBoardDetail(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public void createBoard(CreateBoard req) {
        Writer writer = writerRepository.findByEmail(req.getWriterEmail())
                .orElseGet(() -> Writer.builder().name(req.getWriterName())
                        .email(req.getWriterEmail()).build());

        boardRepository.save(Board.builder().title(req.getTitle()).content(req.getContent()).writer(writer).build());

    }


    @Transactional(rollbackFor = Exception.class)
    public void deleteBoard(final Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(NO_EXISTED_POST.getMessage()));

        boardRepository.delete(board);
    }
}
