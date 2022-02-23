package com.oracle.HomeTheater.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.HomeTheater.model.Member;
import com.oracle.HomeTheater.model.Bbs;
import com.oracle.HomeTheater.model.ChoiceMovie;
import com.oracle.HomeTheater.model.Movie;
import com.oracle.HomeTheater.model.Reservation;
import com.oracle.HomeTheater.model.SeatandTime;

@Repository
public class CH_DaoImpl implements CH_Dao {
	@Autowired
	private SqlSession session;

	@Override
	public List<Movie> SearchMovieList(Movie movie) {
		System.out.println("CH_DaoImpl SearchMovieList Start...");
		List<Movie> SearchMovieList = null;
		try {
			SearchMovieList = session.selectList("CH_SearchMovieList", movie);
		} catch (Exception e) {
			System.out.println("CH_DaoImpl SearchMovieList Excetption->"+e.getMessage());
		}
		return SearchMovieList;
	}

	@Override
	public List<Bbs> SearchBbsList(Bbs bbs) {
		System.out.println("CH_DaoImpl SearchBbsList Start...");
		List<Bbs> SearchBbsList = null;
		try {
			SearchBbsList = session.selectList("CH_SearchBbsList", bbs);
		} catch (Exception e) {
			System.out.println("CH_DaoImpl SearchBbsList Excetption->"+e.getMessage());
		}
		return SearchBbsList;
	}

	@Override
	public Member searchUserInfo(String m_id) {
		Member member = new Member();
		System.out.println("CH_DaoImpl searchUserInfo Start...");
		try {
			member = session.selectOne("CH_SearchUserInfo", m_id);
		} catch (Exception e) {
			System.out.println("CH_DaoImpl searchUserInfo Excetption->"+e.getMessage());
		}
		return member;
	}

	@Override
	public int memberUpdate(Member member) {
		int update = 0;
		System.out.println("CH_DaoImpl memberUpdate Start...");
		try {
			update = session.update("CH_MemberUpdate", member);
		} catch (Exception e) {
			System.out.println("CH_DaoImpl memberUpdate Excetption->"+e.getMessage());
		}
		return update;
	}

	@Override
	public int memberDelete(String m_id) {
		int result = 0;
		System.out.println("CH_DaoImpl memberDelete Start...");
		try {
			result = session.delete("CH_MemberDelete", m_id);
		} catch (Exception e) {
			System.out.println("CH_DaoImpl memberDelete Excetption->"+e.getMessage());
		}
		return result;
	}

	@Override
	public int idCheck(String m_id) {
		int cnt = 0;
		System.out.println("CH_DaoImpl idCheck Start...");
		try {
			cnt = session.selectOne("CH_IdCheck", m_id);
		} catch (Exception e) {
			System.out.println("CH_DaoImpl idCheck Excetption->"+e.getMessage());
		}
		return cnt;
	}

	@Override
	public String checkEmail_Pw(String m_id) {
		String result = null;
		System.out.println("CH_DaoImpl checkEmail_Pw Start...");
		try {
			result = session.selectOne("CH_CheckEmail_Pw", m_id);
		} catch (Exception e) {
			System.out.println("CH_DaoImpl checkEmail_Pw Excetption->"+e.getMessage());
		}
		return result;
	}

	@Override
	public int tempPasswrodUpdate(Member member) {
		int update = 0;
		System.out.println("CH_DaoImpl tempPasswrodUpdate Start...");
		try {
			update = session.update("CH_TempPasswrodUpdate", member);
		} catch (Exception e) {
			System.out.println("CH_DaoImpl tempPasswrodUpdate Excetption->"+e.getMessage());
		}
		return update;
	}

	@Override
	public int phoneCheck(String m_phonenumber) {
		int cnt = 0;
		System.out.println("CH_DaoImpl phoneCheck Start...");
		try {
			cnt = session.selectOne("CH_PhoneCheck", m_phonenumber);
		} catch (Exception e) {
			System.out.println("CH_DaoImpl phoneCheck Excetption->"+e.getMessage());
		}
		return cnt;
	}

	@Override
	public String checkEmail_Id(String m_phonenumber) {
		String result = null;
		System.out.println("CH_DaoImpl checkEmail_Id Start...");
		try {
			result = session.selectOne("CH_CheckEmail_Id", m_phonenumber);
		} catch (Exception e) {
			System.out.println("CH_DaoImpl checkEmail_Id Excetption->"+e.getMessage());
		}
		return result;

	}

	@Override
	public String findName(String m_phonenumber) {
		String result = null;
		System.out.println("CH_DaoImpl findName Start...");
		try {
			result = session.selectOne("CH_FindName", m_phonenumber);
		} catch (Exception e) {
			System.out.println("CH_DaoImpl findName Excetption->"+e.getMessage());
		}
		return result;
	}

	@Override
	public String findId(String m_phonenumber) {
		String id = null;
		System.out.println("CH_DaoImpl findId Start...");
		try {
			id = session.selectOne("CH_FindId", m_phonenumber);
		} catch (Exception e) {
			System.out.println("CH_DaoImpl findId Excetption->"+e.getMessage());
		}
		return id;
	}

	@Override
	public int memberPwUpdate(Member member) {
		int update = 0;
		System.out.println("CH_DaoImpl memberPwUpdate Start...");
		try {
			update = session.update("CH_MemberPwUpdate", member);
		} catch (Exception e) {
			System.out.println("CH_DaoImpl memberPwUpdate Excetption->"+e.getMessage());
		}
		return update;
	}

	@Override
	public List<ChoiceMovie> getMoNumList(ChoiceMovie choice) {
		System.out.println("CH_DaoImpl getMoNumList Start...");
		List<ChoiceMovie> GetMoNumList = null;
		try {
			GetMoNumList = session.selectList("CH_GetMoNumList", choice);
		} catch (Exception e) {
			System.out.println("CH_DaoImpl getMoNumList Excetption->"+e.getMessage());
		}
		return GetMoNumList;
	}

	@Override
	public List<Movie> InterestMovieList(Movie movie) {
		System.out.println("CH_DaoImpl InterestMovieList Start...");
		List<Movie> InterestMovieList = null;
		try {
			InterestMovieList = session.selectList("CH_InterestMovieList", movie);
		} catch (Exception e) {
			System.out.println("CH_DaoImpl InterestMovieList Excetption->"+e.getMessage());
		}
		return InterestMovieList;
	}

	@Override
	public List<Reservation> checkReservationInfo(Reservation reservation) {
		System.out.println("CH_DaoImpl checkReservationInfo Start...");
		List<Reservation> checkReservationInfo = null;
		try {
			checkReservationInfo = session.selectList("CH_CheckReservationInfo", reservation);
		} catch (Exception e) {
			System.out.println("CH_DaoImpl checkReservationInfo Excetption->"+e.getMessage());
		}
		return checkReservationInfo;
	}

	@Override
	public List<SeatandTime> searchSeatInfo(SeatandTime seatTime) {
		System.out.println("CH_DaoImpl searchSeatInfo Start...");
		List<SeatandTime> searchSeatInfo = null;
		try {
			searchSeatInfo = session.selectList("CH_SearchSeatInfo", seatTime);
		} catch (Exception e) {
			System.out.println("CH_DaoImpl searchSeatInfo Excetption->"+e.getMessage());
		}
		return searchSeatInfo;
	}

	@Override
	public List<Member> memberList(Member member) {
		System.out.println("CH_DaoImpl memberList Start...");
		List<Member> memberList = null;
		try {
			memberList = session.selectList("CH_MemberList", member);
		} catch (Exception e) {
			System.out.println("CH_DaoImpl memberList Excetption->"+e.getMessage());
		}
		return memberList;
	}

	@Override
	public int adminUpdateMember(Member member) {
		int update = 0;
		System.out.println("CH_DaoImpl adminUpdateMember Start...");
		try {
			update = session.update("CH_AdminUpdateMember", member);
		} catch (Exception e) {
			System.out.println("CH_DaoImpl adminUpdateMember Excetption->"+e.getMessage());
		}
		return update;
	}

	@Override
	public List<Reservation> reservationList(Reservation reservation) {
		System.out.println("CH_DaoImpl reservationList Start...");
		List<Reservation> reservationList = null;
		try {
			reservationList = session.selectList("CH_ReservationList", reservation);
		} catch (Exception e) {
			System.out.println("CH_DaoImpl reservationList Excetption->"+e.getMessage());
		}
		return reservationList;
	}

	@Override
	public int adminUpdateReservation(Reservation reservation) {
		int update = 0;
		System.out.println("CH_DaoImpl adminUpdateReservation Start...");
		try {
			update = session.update("CH_AdminUpdateReservation", reservation);
		} catch (Exception e) {
			System.out.println("CH_DaoImpl adminUpdateReservation Excetption->"+e.getMessage());
		}
		return update;
	}

	@Override
	public List<Bbs> mainBbsList(Bbs bbs) {
		System.out.println("CH_DaoImpl mainBbsList Start...");
		List<Bbs> mainBbsList = null;
		try {
			mainBbsList = session.selectList("CH_MainBbsList", bbs);
		} catch (Exception e) {
			System.out.println("CH_DaoImpl mainBbsList Excetption->"+e.getMessage());
		}
		return mainBbsList;
	}

	@Override
	public List<Bbs> bbsSearchTotal(Bbs bbs) {
		System.out.println("CH_DaoImpl bbsSearchTotal Start...");
		List<Bbs> bbsSearchTotal = null;
		try {
			bbsSearchTotal = session.selectList("CH_BbsSearchTotal", bbs);
		} catch (Exception e) {
			System.out.println("CH_DaoImpl bbsSearchTotal Excetption->"+e.getMessage());
		}
		return bbsSearchTotal;
	}

	@Override
	public List<Bbs> bbsSearchTitle(Bbs bbs) {
		System.out.println("CH_DaoImpl bbsSearchTitle Start...");
		List<Bbs> bbsSearchTitle = null;
		try {
			bbsSearchTitle = session.selectList("CH_BbsSearchTitle", bbs);
		} catch (Exception e) {
			System.out.println("CH_DaoImpl bbsSearchTitle Excetption->"+e.getMessage());
		}
		return bbsSearchTitle;
	}

	@Override
	public List<Bbs> bbsSearchContent(Bbs bbs) {
		System.out.println("CH_DaoImpl bbsSearchContent Start...");
		List<Bbs> bbsSearchContent = null;
		try {
			bbsSearchContent = session.selectList("CH_BbsSearchContent", bbs);
		} catch (Exception e) {
			System.out.println("CH_DaoImpl bbsSearchContent Excetption->"+e.getMessage());
		}
		return bbsSearchContent;
	}

	@Override
	public List<Bbs> bbsSearchId(Bbs bbs) {
		System.out.println("CH_DaoImpl bbsSearchId Start...");
		List<Bbs> bbsSearchId = null;
		try {
			bbsSearchId = session.selectList("CH_BbsSearchId", bbs);
		} catch (Exception e) {
			System.out.println("CH_DaoImpl bbsSearchId Excetption->"+e.getMessage());
		}
		return bbsSearchId;
	}








	



	








	
	


	
}
