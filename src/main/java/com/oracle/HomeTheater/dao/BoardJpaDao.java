package com.oracle.HomeTheater.dao;

import com.oracle.HomeTheater.domain.BoardJpa;
import com.oracle.HomeTheater.model.Board;
import com.oracle.HomeTheater.repository.BoardRepository;
import com.oracle.HomeTheater.repository.MemberRepository;
import com.oracle.HomeTheater.webMethod.BoardMethod;
import com.oracle.HomeTheater.webMethod.DTOConverter;
import com.oracle.HomeTheater.webMethod.MemberMethod;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class BoardJpaDao implements BoardDao {
    private final BoardRepository boardRepository;
    private final DTOConverter dtoConverter;
    private final BoardMethod boardMethod;
    private final MemberMethod memberMethod;
    private final MemberRepository memberRepository;

    @Override
    public int total(Board board) {
        log.info("BoardJpaDao total start");
        boardMethod.boardNullCheck(board);
        BoardJpa boardJpa = dtoConverter.convertorDtoToEntityBoard(board);
        return boardRepository.totalBoard(boardJpa);
    }


    //paging다시 만들기
    @Override
    public List<Board> listBoard(Board board) {
      return null;
    }

    @Override
    public Board noticeContents(Board board) {
        log.info("noticeContents listBoard start");
        boardMethod.boardNullCheck(board);
        BoardJpa boardJpa = dtoConverter.convertorDtoToEntityBoard(board);
        boardRepository.updateHit(boardJpa);//조회수 증가
        BoardJpa findBoardJpa = boardRepository.findBoard(boardJpa);
        return dtoConverter.convertorEntityToDtoBoard(findBoardJpa);
    }

    @Override
    public int noticeWrite(Board board, String loginMember) {
        log.info("noticeContents noticeWrite start");
        boardMethod.boardNullCheck(board);
        memberMethod.MemberNullCheck(loginMember);
        BoardJpa boardJpa = dtoConverter.convertorDtoToEntityBoard(board);
        boardMethod.BoardMemberSetting(loginMember, boardJpa);
        return boardRepository.insertBoard(boardJpa);
    }
    @Override
    public int contentsDelete(Board board) {
        log.info("noticeContents contentsDelete start");
        boardMethod.boardNullCheck(board);
        BoardJpa boardJpa = dtoConverter.convertorDtoToEntityBoard(board);
        return boardRepository.deleteBoard(boardJpa);
    }

    @Override
    public int contentsUpdate(Board board) {
        log.info("noticeContents contentsDelete start");
        boardMethod.boardNullCheck(board);
        BoardJpa boardJpa = dtoConverter.convertorDtoToEntityBoard(board);
        return boardRepository.updateBoard(boardJpa);
    }

    @Override
    public Page<Board> listBoardJpa(Pageable pageable, Board board) {
        log.info("noticeContents contentsDelete start");
        boardMethod.boardNullCheck(board);
        BoardJpa boardJpa = dtoConverter.convertorDtoToEntityBoard(board);
        Page<BoardJpa> boardJpaList =boardRepository.findBoardListOfCategory(pageable,boardJpa);
        return dtoConverter.pageBoardJpaListToPageBoardList(boardJpaList);

    }
}
