package com.oracle.HomeTheater.service;

import java.util.List;

import com.oracle.HomeTheater.dao.BoardDao;
import com.oracle.HomeTheater.model.Board;
import com.oracle.HomeTheater.webMethod.BoardMethod;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@Slf4j
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    //JPA 사용
    @Qualifier("boardJpaDao")
    @Autowired
    private BoardDao boardDao;
    private final BoardMethod boardMethod;

    @Override
    public int total(Board board) {
        log.info("total Start total...");
        int totCnt = boardDao.total(board);
        return totCnt;
    }


    @Override
    public List<Board> listboard(Board board) {
        log.info("listboard boardList Start...");
        return boardDao.listBoard(board);
    }

    @Override
    public Board noticeContents(Board board) {
        log.info("noticeContents Start noticeContents...");
        return boardDao.noticeContents(board);
    }


    @Override
    public int noticeWrite(Board board, String loginMember) {
        log.info("noticeWrite noticeWrite start......");
        return boardDao.noticeWrite(board, loginMember);
    }

    @Override
    public int contentsDelete(Board board) {
        log.info("contentsDelete contentsDelete start......");
        return boardDao.contentsDelete(board);
    }


    @Override
    public int contentsUpdate(Board board) {
        log.info("contentsUpdate contentsUpdate start......");
        return boardDao.contentsUpdate(board);
    }

    @Override
    public Page<Board> listboardJpa(Pageable pageable, Board board) {
        log.info("listboardJpa contentsUpdate start......");
        pageable = boardMethod.getPageableBoard(pageable);
        return boardDao.listBoardJpa(pageable, board);

    }
}