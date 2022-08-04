package com.oracle.HomeTheater.dao;

import com.oracle.HomeTheater.domain.MemberJpa;
import com.oracle.HomeTheater.model.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.*;

@Transactional
@SpringBootTest
class BoardJpaMyBatisDaoTest {
    @Qualifier("boardMyBatisDao")
    @Autowired
    BoardDao boardDao;
    @Autowired
    TestDao testDao;
    @PersistenceContext
    EntityManager em;

    @BeforeEach
    void testInitialization() {
        testDao.testInitialization();
        MemberJpa memberJpa = new MemberJpa("admin","123","조인태","010-2233-2525","집","123");
        em.persist(memberJpa);
        em.flush();
        em.clear();
    }


    @Test
    void insertBoard() {
        Board board = new Board(1L,1, "testname", "testcontent", "11", 0);
        testDao.insertBoard(board);
    }

    @Test
    void total() {
        Board board = new Board(1L,1, "testname", "testcontent", "11", 0);
        Board board2 = new Board(2L,1, "testname", "testcontent", "11", 0);
        testDao.insertBoard(board);
        testDao.insertBoard(board2);
        int total = boardDao.total(board);
        assertThat(total).isEqualTo(2);
    }

    @Test
    void listBoard() {
    }

    @Test
    void noticeContents() {
    }

    @Test
    void noticeWrite() {
    }

    @Test
    void contentsDelete() {
    }

    @Test
    void contentsUpdate() {
    }
}