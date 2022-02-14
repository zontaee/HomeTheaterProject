package com.oracle.HomeTheater.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.HomeTheater.model.Member;
import com.oracle.HomeTheater.model.Bbs;
import com.oracle.HomeTheater.model.ChoiceMovie;
import com.oracle.HomeTheater.model.Movie;

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
	public List<ChoiceMovie> GetMoNumList(ChoiceMovie choice) {
		System.out.println("CH_DaoImpl GetMoNumList Start...");
		List<ChoiceMovie> GetMoNumList = null;
		try {
			GetMoNumList = session.selectList("CH_GetMoNumList", choice);
		} catch (Exception e) {
			System.out.println("CH_DaoImpl GetMoNumList Excetption->"+e.getMessage());
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






	



	








	
	


	
}
