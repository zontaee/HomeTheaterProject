package com.oracle.HomeTheater.repository;

import com.oracle.HomeTheater.domain.BoardJpa;
import com.oracle.HomeTheater.domain.QBoard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import java.util.List;

@Slf4j
public class BoardRepositoryCustomImpl implements BoardRepositoryCustom {
    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public BoardRepositoryCustomImpl(EntityManager em, JPAQueryFactory queryFactory) {
        this.em = em;
        this.queryFactory = queryFactory;
    }

    QBoard board = new QBoard("board"); // variable -> 별칭


    @Override
    public int totalBoard(BoardJpa boardJpa) {
        Long total = queryFactory.
                select(this.board.count()).
                from(this.board).
                where(this.board.boardCategory.eq(boardJpa.getBoardCategory())).
                fetchOne();

        return Math.toIntExact(total);
    }

    @Override
    public List<BoardJpa> findBoardList(BoardJpa board) {
        List<BoardJpa> fetch = queryFactory.
                selectFrom(this.board).
                fetch();
        return fetch;
    }

    @Override
    public BoardJpa findBoard(BoardJpa boardJpa) {
        BoardJpa findBoardJpa = queryFactory.
                selectFrom(this.board).
                where(this.board.boardNo.eq(boardJpa.getBoardNo()).
                        and(this.board.boardCategory.eq(boardJpa.getBoardCategory()))).
                fetchOne();
        return findBoardJpa;
    }

    @Override
    public void updateHit(BoardJpa boardJpa) {
        queryFactory.
                update(this.board).
                set(this.board.boardHit, this.board.boardHit.add(1)).
                where(this.board.boardNo.eq(boardJpa.getBoardNo()).
                        and(this.board.boardCategory.eq(boardJpa.getBoardCategory()))).
                execute();
    }

    @Override
    public int insertBoard(BoardJpa boardJpa) {
        int checkNumber;
        try {
            em.persist(boardJpa);
            em.flush();
            checkNumber = 1;
        } catch (Exception e) {
            log.info(e.getMessage());
            checkNumber = 0;
        }
        return checkNumber;

    }

    @Override
    public int deleteBoard(BoardJpa boardJpa) {

        int resultNumber;
        try {
            queryFactory.
                    delete(this.board).
                    where(this.board.boardNo.eq(boardJpa.getBoardNo()).
                            and(this.board.boardCategory.eq(boardJpa.getBoardCategory()))).
                    execute();
            resultNumber = 1;
        } catch (Exception e) {
            log.info(e.getMessage());
            resultNumber = 0;
        }
        return resultNumber;

    }

    @Override
    public int updateBoard(BoardJpa boardJpa) {
        int resultNumber;
        try {
            queryFactory.
                    update(this.board).
                    set(this.board.boardTitle, boardJpa.getBoardTitle()).
                    set(this.board.boardContent, boardJpa.getBoardContent()).
                    where(this.board.boardNo.eq(boardJpa.getBoardNo()).
                            and(this.board.boardCategory.eq(boardJpa.getBoardCategory()))).
                    execute();
            resultNumber = 1;
        } catch (Exception e) {
            log.info(e.getMessage());
            resultNumber = 0;
        }

        return resultNumber;
    }


}
