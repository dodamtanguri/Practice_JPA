package com.example.practice_jpa.contents.repository;

import com.example.practice_jpa.contents.dto.QBoardDto;
import com.example.practice_jpa.contents.model.Board;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.example.practice_jpa.contents.dto.BoardDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.NoSuchElementException;


import static com.example.practice_jpa.common.exception.CustomRequestException.NO_EXISTED_POST;
import static com.example.practice_jpa.contents.model.QBoard.board;
import static com.example.practice_jpa.contents.model.QWriter.writer;

@Repository
public class BoardRepositorySupport extends QuerydslRepositorySupport {

    public BoardRepositorySupport() {
        super(Board.class);
    }

    public Page<BoardDto> getBoardList(final Pageable pageable) {
        final JPQLQuery<BoardDto> query = from(board)
                .where(board.enabled.isFalse()).select(new QBoardDto(board, writer));

        final List<BoardDto> projectDtoList = getQuerydsl().applyPagination(pageable, query).fetch();
        return new PageImpl<>(projectDtoList, pageable, query.fetchCount());
    }

    public BoardDto getBoardDetail(final Long id) {
        BooleanExpression filter = board.enabled.isTrue()
                .and(board.id.eq(id));
        Board boardEntity = new JPAQueryFactory(getEntityManager()).selectFrom(board).where(filter).fetchOne();
        if (boardEntity == null) {
            throw new NoSuchElementException(NO_EXISTED_POST.getMessage());
        }
        return new BoardDto(boardEntity);
    }
}
