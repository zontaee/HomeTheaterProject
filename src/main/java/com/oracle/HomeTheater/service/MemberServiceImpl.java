package com.oracle.HomeTheater.service;


import java.util.List;

import com.oracle.HomeTheater.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.HomeTheater.dao.MemberDao;
import com.oracle.HomeTheater.model.Board;


@Service
@Slf4j
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public List<Movie> SearchMovieList(Movie movie) {
		log.info("CH_ServiceImpl SearchMovieList Start...");
		List<Movie> SearchMovieList = null;
		SearchMovieList = memberDao.SearchMovieList(movie);
		return SearchMovieList;
	}

	@Override
	public List<Board> SearchboardList(Board board) {
		log.info("CH_ServiceImpl SearchboardList Start...");
		List<Board> searchBoardList = null;
		searchBoardList = memberDao.SearchBoardList(board);
		return searchBoardList;
	}

	@Override
	public Member searchUserInfo(String m_id) {
		Member member = null;
		log.info("CH_ServiceImpl searchUserInfo Start...");
		member = memberDao.searchUserInfo(m_id);
		return member;
	}

	@Override
	public int memberUpdate(Member member) {
		int update = 0;
		log.info("CH_ServiceImpl memberUpdate Start...");
		update = memberDao.memberUpdate(member);
		return update;
	}

	@Override
	public int memberDelete(String m_id) {
		int result = 0;
		log.info("CH_ServiceImpl memberDelete Start...");
		result = memberDao.memberDelete(m_id);
		return result;
	}

	@Override
	public int idCheck(String m_id) {
		log.info("CH_ServiceImpl idCheck Start...");
		int cnt = memberDao.idCheck(m_id);
		return cnt;
	}

	@Override
	public String checkEmail_Pw(String m_id) {
		log.info("CH_ServiceImpl checkEmail_Pw Start...");
		String result = memberDao.checkEmail_Pw(m_id);
		return result;
	}

	@Override
	public int tempPasswrodUpdate(Member member) {
		int update = 0;
		log.info("CH_ServiceImpl tempPasswrodUpdate Start...");
		update = memberDao.tempPasswrodUpdate(member);
		return update;
	}

	@Override
	public int phoneCheck(String m_phonenumber) {
		log.info("CH_ServiceImpl phoneCheck Start...");
		int cnt = memberDao.phoneCheck(m_phonenumber);
		return cnt;
	}

	@Override
	public String checkEmail_Id(String m_phonenumber) {
		log.info("CH_ServiceImpl checkEmail_Id Start...");
		String result = memberDao.checkEmail_Id(m_phonenumber);
		return result;
	}

	@Override
	public String findName(String m_phonenumber) {
		log.info("CH_ServiceImpl checkEmail_Id Start...");
		String result = memberDao.findName(m_phonenumber);
		return result;
	}

	@Override
	public String findId(String m_phonenumber) {
		log.info("CH_ServiceImpl findId Start...");
		String id = memberDao.findId(m_phonenumber);
		return id;
	}

	@Override
	public int memberPwUpdate(Member member) {
		int update = 0;
		log.info("CH_ServiceImpl memberPwUpdate Start...");
		update = memberDao.memberPwUpdate(member);
		return update;
	}

	@Override
	public List<ChoiceMovie> getMoNumList(ChoiceMovie choice) {
		log.info("CH_ServiceImpl getMoNumList Start...");
		List<ChoiceMovie> GetMoNumList = null;
		GetMoNumList = memberDao.getMoNumList(choice);
		return GetMoNumList;
	}

	@Override
	public List<Movie> InterestMovieList(Movie movie) {
		log.info("CH_ServiceImpl InterestMovieList Start...");
		List<Movie> InterestMovieList = null;
		InterestMovieList = memberDao.InterestMovieList(movie);
		return InterestMovieList;
	}

	@Override
	public List<Reservation> checkReservationInfo(Reservation reservation) {
		log.info("CH_ServiceImpl checkReservationInfo Start...");
		List<Reservation> checkReservationInfo = null;
		checkReservationInfo = memberDao.checkReservationInfo(reservation);
		return checkReservationInfo;
	}

	@Override
	public List<SeatandTime> searchSeatInfo(SeatandTime seatTime) {
		log.info("CH_ServiceImpl searchSeatInfo Start...");
		List<SeatandTime> searchSeatInfo = null;
		searchSeatInfo = memberDao.searchSeatInfo(seatTime);
		return searchSeatInfo;
	}

	@Override
	public List<Member> memberList(Member member) {
		log.info("CH_ServiceImpl memberList Start...");
		List<Member> memberList = null;
		memberList = memberDao.memberList(member);
		return memberList;
	}

	@Override
	public int adminUpdateMember(Member member) {
		int update = 0;
		log.info("CH_ServiceImpl adminUpdateMember Start...");
		update = memberDao.adminUpdateMember(member);
		return update;
	}

	@Override
	public List<Reservation> reservationList(Reservation reservation) {
		log.info("CH_ServiceImpl reservationList Start...");
		List<Reservation> reservationList = null;
		reservationList = memberDao.reservationList(reservation);
		return reservationList;
	}

	@Override
	public int adminUpdateReservation(Reservation reservation) {
		int update = 0;
		log.info("CH_ServiceImpl adminUpdateReservation Start...");
		update = memberDao.adminUpdateReservation(reservation);
		return update;
	}

	@Override
	public List<Board> mainboardList(Board board) {
		log.info("CH_ServiceImpl mainboardList Start...");
		List<Board> mainBoardList = null;
		mainBoardList = memberDao.mainBoardList(board);
		return mainBoardList;
	}

	@Override
	public List<Board> boardSearchTotal(Board board) {
		log.info("CH_ServiceImpl boardSearchTotal Start...");
		List<Board> boardSearchTotal = null;
		boardSearchTotal = memberDao.BoardSearchTotal(board);
		return boardSearchTotal;
	}

	@Override
	public List<Board> boardSearchTitle(Board board) {
		log.info("CH_ServiceImpl boardSearchTitle Start...");
		List<Board> boardSearchTitle = null;
		boardSearchTitle = memberDao.BoardSearchTitle(board);
		return boardSearchTitle;
	}

	@Override
	public List<Board> boardSearchContent(Board board) {
		log.info("CH_ServiceImpl boardSearchContent Start...");
		List<Board> boardSearchContent = null;
		boardSearchContent = memberDao.BoardSearchContent(board);
		return boardSearchContent;
	}

	@Override
	public List<Board> boardSearchId(Board board) {
		log.info("CH_ServiceImpl boardSearchId Start...");
		List<Board> boardSearchId = null;
		boardSearchId = memberDao.BoardSearchId(board);
		return boardSearchId;
	}


	


	
	
	

	
	
	
	

}
