package com.oracle.HomeTheater.service;

import com.oracle.HomeTheater.dao.TestDao;
import com.oracle.HomeTheater.domain.MemberJpa;
import com.oracle.HomeTheater.model.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class BoardJpaServiceImplTest {
    @Autowired
    BoardService boardService;
    @Autowired
    TestDao testDao;
    @PersistenceContext
    EntityManager em;

    @BeforeEach
    void testInitialization() {
        testDao.testInitialization();
        MemberJpa memberJpa = new MemberJpa("admin", "123", "조인태", "010-2233-2525", "집", "123");
        em.persist(memberJpa);
        em.flush();
        em.clear();
    }


    @Test
    void total() {
        Board board = new Board(1L, 1, "testname", "testcontent", "11", 0);
        testDao.insertBoard(board);

        int total = boardService.total(board);
        assertThat(total).isEqualTo(1);

    }

    @Test
    void listboard() {
        Board board = new Board(1L, 1, "testname", "testcontent", "11", 0);
        testDao.insertBoard(board);
        int total = 1;
        String currentPage = "1";
        Paging pg = new Paging(total, currentPage);
        board.setStart(pg.getStart());   // 시작시 1
        board.setEnd(pg.getEnd());        //시작시 10
        List<Board> listboard = boardService.listboard(board);
        assertThat(listboard.size()).isEqualTo(1);
        assertThat(listboard.get(0).getBoard_title()).isEqualTo("testname");
    }

    @Test
    void noticeContents() {
        Board board = new Board(1L, 1, "testname", "testcontent", "11", 0);
        testDao.insertBoard(board);
        Board boardContents = boardService.noticeContents(board);
        assertThat(boardContents.getBoard_title()).isEqualTo("testname");


    }

    @Test
    void noticeWrite() {
        Board board = new Board(1L, 1, "testname", "testcontent", "11", 0);
        testDao.insertBoard(board);
        Board board2 = new Board(1, "testname", "testcontent", "11", 0);
        int resultNumber = boardService.noticeWrite(board);
        assertThat(resultNumber).isEqualTo(1);


    }

    @Test
    void contentsDelete() {
        Board board = new Board(1L, 1, "testname", "testcontent", "11", 0);
        testDao.insertBoard(board);
        int resultnumber = boardService.contentsDelete(board);
        assertThat(resultnumber).isEqualTo(1);

    }

    @Test
    void contentsUpdate() {
        Board board = new Board(1L, 1, "testname", "testcontent", "11", 0);
        testDao.insertBoard(board);
        Board changeBoard = new Board(1L, 1, "changeName", "testcontent", "11", 0);
        int resultnumber = boardService.contentsUpdate(changeBoard);
        assertThat(resultnumber).isEqualTo(1);
        Board findBoard = boardService.noticeContents(changeBoard);
        assertThat(findBoard.getBoard_title()).isEqualTo("changeName");

    }
}