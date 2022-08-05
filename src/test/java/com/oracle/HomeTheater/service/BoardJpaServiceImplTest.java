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
        em.createNativeQuery("DROP SEQUENCE BOARD_SEQ")
                .executeUpdate();
        em.createNativeQuery("create sequence BOARD_SEQ  START WITH 1 INCREMENT BY 1")
                .executeUpdate();

    }


    @Test
    void total() {
        MemberJpa memberJpa = new MemberJpa("admin", "123", "조인태", "010-2233-2525", "집", "123");
        em.persist(memberJpa);
        em.flush();
        em.clear();
        Board board = new Board(1L, 1, "testname", "testcontent", "11", 0,memberJpa.getMemberId());
        testDao.insertBoard(board);

        int total = boardService.total(board);
        assertThat(total).isEqualTo(1);

    }
    @Test
    void noticeContents() {
        MemberJpa memberJpa = new MemberJpa("admin", "123", "조인태", "010-2233-2525", "집", "123");
        em.persist(memberJpa);
        em.flush();
        em.clear();
        Board board = new Board(1L, 1, "testname", "testcontent", "11", 0,memberJpa.getMemberId());
        testDao.insertBoard(board);
        Board boardContents = boardService.noticeContents(board);
        assertThat(boardContents.getBoard_title()).isEqualTo("testname");


    }

    @Test
    void noticeWrite() {
        MemberJpa memberJpa = new MemberJpa("admin", "123", "조인태", "010-2233-2525", "집", "123");
        em.persist(memberJpa);
        em.flush();
        em.clear();
        Board board = new Board(1, "testname", "testcontent", "11", 0,memberJpa.getMemberId());
        testDao.insertBoard(board);
        int resultNumber = boardService.noticeWrite(board);
        assertThat(resultNumber).isEqualTo(1);


    }

    @Test
    void contentsDelete() {
        MemberJpa memberJpa = new MemberJpa("admin", "123", "조인태", "010-2233-2525", "집", "123");
        em.persist(memberJpa);
        em.flush();
        em.clear();
        Board board = new Board(1L, 1, "testname", "testcontent", "11", 0,memberJpa.getMemberId());
        testDao.insertBoard(board);
        int resultnumber = boardService.contentsDelete(board);
        assertThat(resultnumber).isEqualTo(1);

    }

    @Test
    void contentsUpdate() {
        MemberJpa memberJpa = new MemberJpa("admin", "123", "조인태", "010-2233-2525", "집", "123");
        em.persist(memberJpa);
        em.flush();
        em.clear();
        Board board = new Board(1L, 1, "testname", "testcontent", "11", 0,memberJpa.getMemberId());
        testDao.insertBoard(board);
        Board changeBoard = new Board(1L, 1, "changeName", "testcontent", "11", 0,memberJpa.getMemberId());
        int resultnumber = boardService.contentsUpdate(changeBoard);
        assertThat(resultnumber).isEqualTo(1);
        Board findBoard = boardService.noticeContents(changeBoard);
        assertThat(findBoard.getBoard_title()).isEqualTo("changeName");

    }
}