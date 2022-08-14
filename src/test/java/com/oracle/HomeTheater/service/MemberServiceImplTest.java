package com.oracle.HomeTheater.service;

import com.oracle.HomeTheater.dao.TestDao;
import com.oracle.HomeTheater.domain.MemberJpa;
import com.oracle.HomeTheater.model.*;
import com.oracle.HomeTheater.webMethod.DTOConverter;
import com.oracle.HomeTheater.webMethod.MemberMethod;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
@Transactional
@SpringBootTest
class MemberServiceImplTest {
    @Autowired
    MemberService memberService;
    @Autowired
    TestDao testDao;
    @Autowired
    DTOConverter dtoConverter;
    @PersistenceContext
    EntityManager em;

    @BeforeEach
    void testInitialization() {
        em.createNativeQuery("DROP SEQUENCE BOARD_SEQ")
                .executeUpdate();
        em.createNativeQuery("create sequence BOARD_SEQ  START WITH 1 INCREMENT BY 1")
                .executeUpdate();
        em.createNativeQuery("DROP SEQUENCE MOVIE_SEQ")
                .executeUpdate();
        em.createNativeQuery("create sequence MOVIE_SEQ  START WITH 1 INCREMENT BY 1")
                .executeUpdate();
    }


    @Test
    void searchMovieList() {
        MemberJpa memberJpa = new MemberJpa("admin", "123", "조인태", "010-2233-2525", "집", "123");
        em.persist(memberJpa);
        em.flush();
        em.clear();
        Movie movie = new Movie("testMovietitle","이정재","공유","공포","18세","2시간","7월 18일",0,"asd");
        testDao.insertMovie(movie);
        List<Movie> movies = memberService.SearchMovieList(movie);
        assertThat(movies.get(0).getMo_title()).isEqualTo("testMovietitle");


    }

    @Test
    void searchboardList() {
        MemberJpa memberJpa = new MemberJpa("admin", "123", "조인태", "010-2233-2525", "집", "123");
        em.persist(memberJpa);
        em.flush();
        em.clear();
        Board board = new Board(1L, 1, "testname", "testcontent", "11", 0,memberJpa.getMemberId());
        testDao.insertBoard(board);
        List<Board> boards = memberService.SearchboardList(board);
        assertThat(boards.get(0).getBoard_title()).isEqualTo("testname");
    }

    @Test
    void searchUserInfo() {
        MemberJpa memberJpa = new MemberJpa("admin", "123", "조인태", "010-2233-2525", "집", "123");
        em.persist(memberJpa);
        em.flush();
        em.clear();
        Member member = dtoConverter.convertorMemberJpaToMember(memberJpa);
        Member resultMember = memberService.searchUserInfo(member.getM_id());
        assertThat(resultMember.getM_id()).isEqualTo("admin");
    }

    @Test
    void memberUpdate() {
        MemberJpa memberJpa = new MemberJpa("admin", "123", "조인태", "010-2233-2525", "집", "123");
        em.persist(memberJpa);
        em.flush();
        em.clear();
        Member member = new Member("admin", "123", "바뀐이름", "010-2233-2525", "집", "123","1000","a");
        memberService.memberUpdate(member);
        MemberJpa resultMember = em.find(memberJpa.getClass(), "admin");
        assertThat(resultMember.getMemberName()).isEqualTo("바뀐이름");


    }

    @Test
    void memberDelete() {
        MemberJpa memberJpa = new MemberJpa("admin", "123", "조인태", "010-2233-2525", "집", "123");
        em.persist(memberJpa);
        em.flush();
        em.clear();
        Member member = dtoConverter.convertorMemberJpaToMember(memberJpa);
        memberService.memberDelete(member.getM_id());
        assertThatThrownBy(() -> em.find(memberJpa.getClass(),"admin").getMemberId())
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void idCheck() {
        MemberJpa memberJpa = new MemberJpa("admin", "123", "조인태", "010-2233-2525", "집", "123");
        em.persist(memberJpa);
        em.flush();
        em.clear();
        Member member = dtoConverter.convertorMemberJpaToMember(memberJpa);
        int result = memberService.idCheck(member.getM_id());
        assertThat(result).isEqualTo(1);
    }

    @Test
    void checkEmail_Pw() {
        MemberJpa memberJpa = new MemberJpa("admin", "123", "조인태", "010-2233-2525", "집", "whdlsxo123@Naver.com");
        em.persist(memberJpa);
        em.flush();
        em.clear();
        Member member = dtoConverter.convertorMemberJpaToMember(memberJpa);
        String checkEmail_pw = memberService.checkEmail_Pw(member.getM_id());
        assertThat(checkEmail_pw).isEqualTo("whdlsxo123@Naver.com");

    }

    @Test
    void tempPasswrodUpdate() {
        MemberJpa memberJpa = new MemberJpa("admin", "123", "조인태", "010-2233-2525", "집", "whdlsxo123@Naver.com");
        em.persist(memberJpa);
        em.flush();
        em.clear();
        Member member = new Member("admin", "변경된password", "조인태", "010-2233-2525", "집", "123","1000","a");
        memberService.tempPasswrodUpdate(member);
        MemberJpa findMember = em.find(memberJpa.getClass(), "admin");
        assertThat(findMember.getMemberPassword()).isEqualTo("변경된password");

    }

    @Test
    void phoneCheck() {
        MemberJpa memberJpa = new MemberJpa("admin", "123", "조인태", "010-2233-2525", "집", "whdlsxo123@Naver.com");
        em.persist(memberJpa);
        em.flush();
        em.clear();
        Member member = dtoConverter.convertorMemberJpaToMember(memberJpa);
        int result = memberService.phoneCheck(member.getM_phonenumber());
        assertThat(result).isEqualTo(1);
        assertThat(em.find(memberJpa.getClass(),"admin").getMemberPhonenumber()).isEqualTo("010-2233-2525");
    }

    @Test
    void checkEmail_Id() {
        MemberJpa memberJpa = new MemberJpa("admin", "123", "조인태", "010-2233-2525", "집", "whdlsxo123@Naver.com");
        em.persist(memberJpa);
        em.flush();
        em.clear();
        Member member = dtoConverter.convertorMemberJpaToMember(memberJpa);
        String emailId = memberService.checkEmail_Id(member.getM_phonenumber());
        assertThat(emailId).isEqualTo("whdlsxo123@Naver.com");
    }

    @Test
    void findName() {
        MemberJpa memberJpa = new MemberJpa("admin", "123", "조인태", "010-2233-2525", "집", "whdlsxo123@Naver.com");
        em.persist(memberJpa);
        em.flush();
        em.clear();
        Member member = dtoConverter.convertorMemberJpaToMember(memberJpa);
        String name = memberService.findName(member.getM_phonenumber());
        assertThat(name).isEqualTo("조인태");
    }

    @Test
    void findId() {
        MemberJpa memberJpa = new MemberJpa("admin", "123", "조인태", "010-2233-2525", "집", "whdlsxo123@Naver.com");
        em.persist(memberJpa);
        em.flush();
        em.clear();
        Member member = dtoConverter.convertorMemberJpaToMember(memberJpa);
        String id = memberService.findId(member.getM_phonenumber());
        assertThat(id).isEqualTo("admin");

    }

    @Test
    void memberPwUpdate() {
        MemberJpa memberJpa = new MemberJpa("admin", "123", "조인태", "010-2233-2525", "집", "whdlsxo123@Naver.com");
        em.persist(memberJpa);
        em.flush();
        em.clear();
        Member member = new Member("admin", "변경된password", "조인태", "010-2233-2525", "집", "123","1000","a");
        int result = memberService.memberPwUpdate(member);
        assertThat(result).isEqualTo(1);
        assertThat(em.find(memberJpa.getClass(),"admin").getMemberPassword()).isEqualTo("변경된password");
    }

    @Test
    void interestMovieList() {
        MemberJpa memberJpa = new MemberJpa("admin", "123", "조인태", "010-2233-2525", "집", "123");
        em.persist(memberJpa);
        em.flush();
        em.clear();
        Movie movie = new Movie("testMovietitle","이정재","공유","공포","18세","2시간","7월 18일",0,"asd");
        testDao.insertMovie(movie);
        Movie findMovie = new Movie(1,"testMovietitle","이정재","공유","공포","18세","2시간","7월 18일",0,"asd");
        List<Movie> movies = memberService.InterestMovieList(findMovie);
        assertThat(movies.get(0).getMo_title()).isEqualTo("testMovietitle");
    }

    @Test
    void checkReservationInfo() {
        Movie movie = new Movie("testMovietitle","이정재","공유","공포","18세","2시간","7월 18일",0,"asd");
        testDao.insertMovie(movie);
        Reservation reservation = new Reservation("1","2시","5월7일","1","T","카카오머니","20000","오늘","admin",1);
        testDao.insertReservation(reservation);
        List<Reservation> reservations = memberService.checkReservationInfo(reservation);
        assertThat(reservations.get(0).getM_id()).isEqualTo("admin");

    }

    @Test
    void searchSeatInfo() {
        Reservation reservation = new Reservation("1","2","5월7일","1","T","카카오머니","20000","오늘","admin",1);
        testDao.insertReservation(reservation);
        SeatandTime seatandTime = new SeatandTime("1","2","5월7일",1,"T","admin");
        testDao.insertSeatAndTime(seatandTime);
        List<SeatandTime> seatandTimes = memberService.searchSeatInfo(seatandTime);
        assertThat(seatandTimes.get(0).getMo_number()).isEqualTo(1);

    }

    @Test
    void memberList() {
        MemberJpa memberJpa = new MemberJpa("test", "123", "조인태", "010-2233-2525", "집", "whdlsxo123@Naver.com");
        em.persist(memberJpa);
        em.flush();
        em.clear();
        Member member = dtoConverter.convertorMemberJpaToMember(memberJpa);
        List<Member> members = memberService.memberList(member);
        assertThat(members.size()).isEqualTo(1);
    }

    @Test
    void adminUpdateMember() {
        MemberJpa memberJpa = new MemberJpa("admin", "123", "조인태", "010-2233-2525", "집", "whdlsxo123@Naver.com");
        em.persist(memberJpa);
        em.flush();
        em.clear();
        Member member = new Member("admin", "123", "박지성", "010-2233-2525", "집", "123","1000","a");
        int result = memberService.adminUpdateMember(member);
        assertThat(result).isEqualTo(1);
        assertThat(em.find(memberJpa.getClass(),"admin").getMemberName()).isEqualTo("박지성");

    }

    @Test
    void reservationList() {
        Reservation reservation = new Reservation("1","2","5월7일","1","T","카카오머니","20000","오늘","admin",1);
        testDao.insertReservation(reservation);
        List<Reservation> reservations = memberService.reservationList(reservation);
        assertThat(reservations.size()).isEqualTo(1);

    }

    @Test
    void adminUpdateReservation() {
        Reservation reservation = new Reservation("1","2","5월7일","1","T","카카오머니","20000","오늘","admin",1);
        testDao.insertReservation(reservation);
        Reservation updateRservation = new Reservation("2","2","5월7일","1","T","카카오머니","20000","오늘","admin",1);
        int result = memberService.adminUpdateReservation(updateRservation);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void mainboardList() {
        MemberJpa memberJpa = new MemberJpa("admin", "123", "조인태", "010-2233-2525", "집", "123");
        em.persist(memberJpa);
        em.flush();
        em.clear();
        Board board = new Board(1L, 1, "testname", "testcontent", "11", 0,memberJpa.getMemberId());
        testDao.insertBoard(board);
        List<Board> boards = memberService.mainboardList(board);
        assertThat(boards.size()).isEqualTo(1);
    }

    @Test
    void boardSearchTotal() {
        MemberJpa memberJpa = new MemberJpa("admin", "123", "조인태", "010-2233-2525", "집", "123");
        em.persist(memberJpa);
        em.flush();
        em.clear();
        Board board = new Board(1L, 1, "testname", "testcontent", "11", 0,memberJpa.getMemberId());
        testDao.insertBoard(board);
        Board findboard = new Board(1L, 1, "test", "testcontent", "11", 0,memberJpa.getMemberId());
        List<Board> boards = memberService.boardSearchTitle(findboard);
        assertThat(boards.get(0).getBoard_title()).isEqualTo("testname");
    }

    @Test
    void boardSearchTitle() {
        MemberJpa memberJpa = new MemberJpa("admin", "123", "조인태", "010-2233-2525", "집", "123");
        em.persist(memberJpa);
        em.flush();
        em.clear();
        Board board = new Board(1L, 1, "testname", "testcontent", "11", 0,memberJpa.getMemberId());
        testDao.insertBoard(board);
        Board findboard = new Board(1L, 1, "test", "testcontent", "11", 0,memberJpa.getMemberId());
        List<Board> boards = memberService.boardSearchTitle(findboard);
        assertThat(boards.get(0).getBoard_title()).isEqualTo("testname");
    }

    @Test
    void boardSearchContent() {
        MemberJpa memberJpa = new MemberJpa("admin", "123", "조인태", "010-2233-2525", "집", "123");
        em.persist(memberJpa);
        em.flush();
        em.clear();
        Board board = new Board(1L, 1, "testname", "testcontent", "11", 0,memberJpa.getMemberId());
        testDao.insertBoard(board);
        Board findboard = new Board(1L, 1, "testname", "test", "11", 0,memberJpa.getMemberId());
        List<Board> boards = memberService.boardSearchTitle(findboard);
        assertThat(boards.get(0).getBoard_content()).isEqualTo("testcontent");
    }

    @Test
    void boardSearchId() {
        MemberJpa memberJpa = new MemberJpa("admin", "123", "조인태", "010-2233-2525", "집", "123");
        em.persist(memberJpa);
        em.flush();
        em.clear();
        Board board = new Board(1L, 1, "testname", "testcontent", "11", 0,memberJpa.getMemberId());
        testDao.insertBoard(board);
        Board findboard = new Board(1L, 1, "testname", "test", "11", 0,memberJpa.getMemberId());
        List<Board> boards = memberService.boardSearchTitle(findboard);
        assertThat(boards.get(0).getM_id()).isEqualTo("admin");
    }
}