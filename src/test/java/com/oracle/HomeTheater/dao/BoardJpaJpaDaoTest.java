package com.oracle.HomeTheater.dao;

import com.oracle.HomeTheater.domain.BoardJpa;
import com.oracle.HomeTheater.domain.MemberJpa;
import com.oracle.HomeTheater.model.Board;
import com.oracle.HomeTheater.repository.BoardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class BoardJpaJpaDaoTest {
    @Autowired
    BoardRepository boardRepository;
    @Autowired
    BoardJpaDao boardJpaDao;
    @Autowired
    TestDao testDao;
    @PersistenceContext
    EntityManager em;
    static MemberJpa memberJpa;
    static BoardJpa boardJpa;
    @BeforeTestMethod
     void  testInfo(){
    }
    @BeforeEach
    void testInitialization() {

        em.createNativeQuery("DROP SEQUENCE BOARD_SEQ")
                .executeUpdate();
        em.createNativeQuery("create sequence BOARD_SEQ  START WITH 1 INCREMENT BY 1")
                .executeUpdate();
    }

    @Test
    void total() {
        MemberJpa memberJpa = new MemberJpa("admin","123","조인태","010-2233-2525","집","123");
        em.persist(memberJpa);
        BoardJpa boardJpa = new BoardJpa( 1,"testname", "testcontent", "11", 0,memberJpa);
        em.persist(boardJpa);
        em.flush();
        em.clear();
        Board board = new Board( 1L,1,"testname", "testcontent", "11", 0,memberJpa.getMemberId());
        int totalBoard = boardJpaDao.total(board);
        assertThat(totalBoard).isEqualTo(1);
    }

    @Test
    void listBoard() {
    }

    @Test
    void noticeContents() {
        MemberJpa memberJpa = new MemberJpa("admin","123","조인태","010-2233-2525","집","123");
        em.persist(memberJpa);
        BoardJpa boardJpa = new BoardJpa( 1,"testname", "testcontent", "11", 0,memberJpa);
        em.persist(boardJpa);
        em.flush();
        em.clear();
        Board board = new Board( 1L,1,"testname", "testcontent", "11", 0);
        Board findBoard = boardJpaDao.noticeContents(board);
        assertThat(findBoard.getBoard_hit()).isEqualTo(1);
        assertThat(findBoard.getM_id()).isEqualTo("admin");


    }

    @Test
    void noticeWrite() {
        MemberJpa memberJpa = new MemberJpa("admin","123","조인태","010-2233-2525","집","123");
        em.persist(memberJpa);
        BoardJpa boardJpa = new BoardJpa( 1,"testname", "testcontent", "11", 0,memberJpa);
        em.persist(boardJpa);
        em.flush();
        em.clear();
        Board board = new Board( 1,"testname", "testcontent", "11", 0,memberJpa.getMemberId());
        int insertCheckNumber = boardJpaDao.noticeWrite(board, memberJpa.getMemberId());
        assertThat(insertCheckNumber).isEqualTo(1);

    }

    @Test
    void contentsDelete() {
        MemberJpa memberJpa = new MemberJpa("admin","123","조인태","010-2233-2525","집","123");
        em.persist(memberJpa);
        BoardJpa boardJpa = new BoardJpa( 1,"testname", "testcontent", "11", 0,memberJpa);
        em.persist(boardJpa);
        em.flush();
        em.clear();
        Board board = new Board( 1L,1,"testname", "testcontent", "11", 0,memberJpa.getMemberId());
        int insertCheckNumber = boardJpaDao.contentsDelete(board);
        assertThat(insertCheckNumber).isEqualTo(1);
    }

    @Test
    void contentsUpdate() {
        MemberJpa memberJpa = new MemberJpa("admin","123","조인태","010-2233-2525","집","123");
        em.persist(memberJpa);
        BoardJpa boardJpa = new BoardJpa( 1,"testname", "testcontent", "11", 0,memberJpa);
        em.persist(boardJpa);
        em.flush();
        em.clear();
        Board board = new Board( 1L,1,"changename", "changecontent", "11", 0,memberJpa.getMemberId());
        boardJpaDao.contentsUpdate(board);
        BoardJpa findBoardjpa = em.find(BoardJpa.class, 1L);
        assertThat(findBoardjpa.getBoardTitle()).isEqualTo("changename");
    }

}