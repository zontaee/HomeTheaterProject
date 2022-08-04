package com.oracle.HomeTheater.dao;

import com.oracle.HomeTheater.domain.BoardJpa;
import com.oracle.HomeTheater.model.Board;
import com.oracle.HomeTheater.repository.BoardRepository;
import com.oracle.HomeTheater.webMethod.BoardMethod;
import com.oracle.HomeTheater.webMethod.DTOConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class BoardJpaDao implements BoardDao {
    private final BoardRepository boardRepository;
    private final DTOConverter dtoConverter;
    private final BoardMethod boardMethod;

    @Override
    public int total(Board board) {
        log.info("BoardJpaDao total start");
        boardMethod.boardNullCheck(board);
        BoardJpa boardJpa = dtoConverter.convertorDtoToEntityBoard(board);
        int total = boardRepository.totalBoard(boardJpa);

        return total;
    }


    //paging다시 만들기
    @Override
    public List<Board> listBoard(Board board) {
        log.info("BoardJpaDao listBoard start");
        boardMethod.boardNullCheck(board);
        BoardJpa boardJpa = dtoConverter.convertorDtoToEntityBoard(board);
        List<BoardJpa> boardJpaList = boardRepository.findBoardList(boardJpa);

        return null;
    }

    @Override
    public Board noticeContents(Board board) {
        log.info("noticeContents listBoard start");
        boardMethod.boardNullCheck(board);
        BoardJpa boardJpa = dtoConverter.convertorDtoToEntityBoard(board);

        boardRepository.updateHit(boardJpa);//조회수 증가
        BoardJpa findBoardJpa = boardRepository.findBoard(boardJpa);
        Board findBoard = dtoConverter.convertorEntityToDtoBoard(findBoardJpa);
        return findBoard;
    }

    @Override
    public int noticeWrite(Board board) {
        log.info("noticeContents noticeWrite start");
        boardMethod.boardNullCheck(board);
        BoardJpa boardJpa = dtoConverter.convertorDtoToEntityBoard(board);
        int insertCheckNumber = boardRepository.insertBoard(boardJpa);
        return insertCheckNumber;
    }

    @Override
    public int contentsDelete(Board board) {
        log.info("noticeContents contentsDelete start");
        boardMethod.boardNullCheck(board);
        BoardJpa boardJpa = dtoConverter.convertorDtoToEntityBoard(board);
        int deleteCheckNumber = boardRepository.deleteBoard(boardJpa);
        return deleteCheckNumber;
    }

    @Override
    public int contentsUpdate(Board board) {
        log.info("noticeContents contentsDelete start");
        boardMethod.boardNullCheck(board);
        BoardJpa boardJpa = dtoConverter.convertorDtoToEntityBoard(board);
        int updateCheckNumber = boardRepository.updateBoard(boardJpa);
        return updateCheckNumber;
    }
}
