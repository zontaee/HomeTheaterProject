package com.oracle.HomeTheater.dao;

import java.util.List;

import com.oracle.HomeTheater.model.Member;
import com.oracle.HomeTheater.model.Bbs;
import com.oracle.HomeTheater.model.ChoiceMovie;
import com.oracle.HomeTheater.model.Movie;


public interface CH_Dao {

	List<Movie> SearchMovieList(Movie movie);
	List<Bbs> SearchBbsList(Bbs bbs);
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
	List<ChoiceMovie> GetMoNumList(ChoiceMovie choice);
	List<Movie> InterestMovieList(Movie movie);


}
