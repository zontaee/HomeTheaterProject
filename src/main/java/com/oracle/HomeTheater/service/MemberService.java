package com.oracle.HomeTheater.service;

import java.util.List;

import com.oracle.HomeTheater.model.*;
import com.oracle.HomeTheater.model.Board;


public interface MemberService {

    List<Movie> SearchMovieList(Movie movie);

    List<Board> SearchboardList(Board board);

    Member searchUserInfo(String m_id);

    int memberUpdate(Member member);

    int memberDelete(String m_id);

    int idCheck(String m_id);

    String checkEmail_Pw(String m_id);

    int tempPasswrodUpdate(Member member);

    int phoneCheck(String m_phonenumber);

    String checkEmail_Id(String m_phonenumber);

    String findName(String m_phonenumber);

    String findId(String m_phonenumber);

    int memberPwUpdate(Member member);

    List<ChoiceMovie> getMoNumList(ChoiceMovie choice);

    List<Movie> InterestMovieList(Movie movie);

    List<Reservation> checkReservationInfo(Reservation reservation);

    List<SeatandTime> searchSeatInfo(SeatandTime seatTime);

    List<Member> memberList(Member member);

    int adminUpdateMember(Member member);

    List<Reservation> reservationList(Reservation reservation);

    int adminUpdateReservation(Reservation reservation);

    List<Board> mainboardList(Board board);

    List<Board> boardSearchTotal(Board board);

    List<Board> boardSearchTitle(Board board);

    List<Board> boardSearchContent(Board board);

    List<Board> boardSearchId(Board board);


}
