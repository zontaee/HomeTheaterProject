package com.oracle.HomeTheater.repository;

import com.oracle.HomeTheater.domain.BoardJpa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardRepositoryCustom {
    int totalBoard(BoardJpa boardJpa);

    List<BoardJpa> findBoardList(BoardJpa board);

    BoardJpa findBoard(BoardJpa boardJpa);

    void updateHit(BoardJpa boardJpa);

    int insertBoard(BoardJpa board);

    int deleteBoard(BoardJpa boardJpa);

    int updateBoard(BoardJpa boardJpa);

    Page<BoardJpa> findBoardListOfCategory(Pageable pageable, BoardJpa boardJpa);
}
