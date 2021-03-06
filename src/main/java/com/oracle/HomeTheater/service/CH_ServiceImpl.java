package com.oracle.HomeTheater.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.HomeTheater.dao.CH_Dao;
import com.oracle.HomeTheater.model.Member;
import com.oracle.HomeTheater.model.Bbs;
import com.oracle.HomeTheater.model.ChoiceMovie;
import com.oracle.HomeTheater.model.Movie;
import com.oracle.HomeTheater.model.Reservation;
import com.oracle.HomeTheater.model.SeatandTime;



@Service
public class CH_ServiceImpl implements CH_Service {
	@Autowired
	private CH_Dao cd;
	
	@Override
	public List<Movie> SearchMovieList(Movie movie) {
		System.out.println("CH_ServiceImpl SearchMovieList Start...");
		List<Movie> SearchMovieList = null;
		SearchMovieList = cd.SearchMovieList(movie);
		return SearchMovieList;
	}

	@Override
	public List<Bbs> SearchBbsList(Bbs bbs) {
		System.out.println("CH_ServiceImpl SearchBbsList Start...");
		List<Bbs> SearchBbsList = null;
		SearchBbsList = cd.SearchBbsList(bbs);
		return SearchBbsList;
	}

	@Override
	public Member searchUserInfo(String m_id) {
		Member member = null;
		System.out.println("CH_ServiceImpl searchUserInfo Start...");
		member = cd.searchUserInfo(m_id);
		return member;
	}

	@Override
	public int memberUpdate(Member member) {
		int update = 0;
		System.out.println("CH_ServiceImpl memberUpdate Start...");
		update = cd.memberUpdate(member);
		return update;
	}

	@Override
	public int memberDelete(String m_id) {
		int result = 0;
		System.out.println("CH_ServiceImpl memberDelete Start...");
		result = cd.memberDelete(m_id);
		return result;
	}

	@Override
	public int idCheck(String m_id) {
		System.out.println("CH_ServiceImpl idCheck Start...");
		int cnt = cd.idCheck(m_id);
		return cnt;
	}

	@Override
	public String checkEmail_Pw(String m_id) {
		System.out.println("CH_ServiceImpl checkEmail_Pw Start...");
		String result = cd.checkEmail_Pw(m_id);
		return result;
	}

	@Override
	public int tempPasswrodUpdate(Member member) {
		int update = 0;
		System.out.println("CH_ServiceImpl tempPasswrodUpdate Start...");
		update = cd.tempPasswrodUpdate(member);
		return update;
	}

	@Override
	public int phoneCheck(String m_phonenumber) {
		System.out.println("CH_ServiceImpl phoneCheck Start...");
		int cnt = cd.phoneCheck(m_phonenumber);
		return cnt;
	}

	@Override
	public String checkEmail_Id(String m_phonenumber) {
		System.out.println("CH_ServiceImpl checkEmail_Id Start...");
		String result = cd.checkEmail_Id(m_phonenumber);
		return result;
	}

	@Override
	public String findName(String m_phonenumber) {
		System.out.println("CH_ServiceImpl checkEmail_Id Start...");
		String result = cd.findName(m_phonenumber);
		return result;
	}

	@Override
	public String findId(String m_phonenumber) {
		System.out.println("CH_ServiceImpl findId Start...");
		String id = cd.findId(m_phonenumber);
		return id;
	}

	@Override
	public int memberPwUpdate(Member member) {
		int update = 0;
		System.out.println("CH_ServiceImpl memberPwUpdate Start...");
		update = cd.memberPwUpdate(member);
		return update;
	}

	@Override
	public List<ChoiceMovie> getMoNumList(ChoiceMovie choice) {
		System.out.println("CH_ServiceImpl getMoNumList Start...");
		List<ChoiceMovie> GetMoNumList = null;
		GetMoNumList = cd.getMoNumList(choice);
		return GetMoNumList;
	}

	@Override
	public List<Movie> InterestMovieList(Movie movie) {
		System.out.println("CH_ServiceImpl InterestMovieList Start...");
		List<Movie> InterestMovieList = null;
		InterestMovieList = cd.InterestMovieList(movie);
		return InterestMovieList;
	}

	@Override
	public List<Reservation> checkReservationInfo(Reservation reservation) {
		System.out.println("CH_ServiceImpl checkReservationInfo Start...");
		List<Reservation> checkReservationInfo = null;
		checkReservationInfo = cd.checkReservationInfo(reservation);
		return checkReservationInfo;
	}

	@Override
	public List<SeatandTime> searchSeatInfo(SeatandTime seatTime) {
		System.out.println("CH_ServiceImpl searchSeatInfo Start...");
		List<SeatandTime> searchSeatInfo = null;
		searchSeatInfo = cd.searchSeatInfo(seatTime);
		return searchSeatInfo;
	}

	@Override
	public List<Member> memberList(Member member) {
		System.out.println("CH_ServiceImpl memberList Start...");
		List<Member> memberList = null;
		memberList = cd.memberList(member);
		return memberList;
	}

	@Override
	public int adminUpdateMember(Member member) {
		int update = 0;
		System.out.println("CH_ServiceImpl adminUpdateMember Start...");
		update = cd.adminUpdateMember(member);
		return update;
	}

	@Override
	public List<Reservation> reservationList(Reservation reservation) {
		System.out.println("CH_ServiceImpl reservationList Start...");
		List<Reservation> reservationList = null;
		reservationList = cd.reservationList(reservation);
		return reservationList;
	}

	@Override
	public int adminUpdateReservation(Reservation reservation) {
		int update = 0;
		System.out.println("CH_ServiceImpl adminUpdateReservation Start...");
		update = cd.adminUpdateReservation(reservation);
		return update;
	}

	@Override
	public List<Bbs> mainBbsList(Bbs bbs) {
		System.out.println("CH_ServiceImpl mainBbsList Start...");
		List<Bbs> mainBbsList = null;
		mainBbsList = cd.mainBbsList(bbs);
		return mainBbsList;
	}

	@Override
	public List<Bbs> bbsSearchTotal(Bbs bbs) {
		System.out.println("CH_ServiceImpl bbsSearchTotal Start...");
		List<Bbs> bbsSearchTotal = null;
		bbsSearchTotal = cd.bbsSearchTotal(bbs);
		return bbsSearchTotal;
	}

	@Override
	public List<Bbs> bbsSearchTitle(Bbs bbs) {
		System.out.println("CH_ServiceImpl bbsSearchTitle Start...");
		List<Bbs> bbsSearchTitle = null;
		bbsSearchTitle = cd.bbsSearchTitle(bbs);
		return bbsSearchTitle;
	}

	@Override
	public List<Bbs> bbsSearchContent(Bbs bbs) {
		System.out.println("CH_ServiceImpl bbsSearchContent Start...");
		List<Bbs> bbsSearchContent = null;
		bbsSearchContent = cd.bbsSearchContent(bbs);
		return bbsSearchContent;
	}

	@Override
	public List<Bbs> bbsSearchId(Bbs bbs) {
		System.out.println("CH_ServiceImpl bbsSearchId Start...");
		List<Bbs> bbsSearchId = null;
		bbsSearchId = cd.bbsSearchId(bbs);
		return bbsSearchId;
	}


	


	
	
	

	
	
	
	

}
