package com.oracle.HomeTheater.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.HomeTheater.model.Member;
import com.oracle.HomeTheater.model.Movie;
import com.oracle.HomeTheater.model.MovieLike;

@Repository
public class SE_DaoImpl implements SE_Dao {
	@Autowired
	private SqlSession session;

	@Override
	public List<Movie> listMoive() {
		List<Movie> movieList = null;
		System.out.println("SE_DaoImpl listMoive Start ...");
		try {
			movieList = session.selectList("SE_ListAllMovie");
			System.out.println("SE_DaoImpl movielist " + movieList.size());
		} catch (Exception e) {
			System.out.println("SE_DaoImpl listMoive Exception->" + e.getMessage());
		}
		return movieList;

	}
	
	@Override
	public Movie movieDetail(int mo_number) {
		Movie movie = null;
		System.out.println("SE_DaoImpl movieDetail Start ...");
		try {
			movie = session.selectOne("SE_SelMovie", mo_number);
			System.out.println("SE_DaoImpl movieDetail getEname->" + movie.getMo_title());
		} catch (Exception e) {
			System.out.println("SE_DaoImpl movieDetail Exception->" + e.getMessage());
		}

		return movie;
	}


	@Override
	public int likeCheck(Map<String, Object> map) {
		System.out.println("SE_DaoImpl likeCheck Start ...");
		int resultStr = 0;
		try {
			resultStr= session.selectOne("SE_SelectMovieLike", map);
			System.out.println("SE_DaoImpl likeCheck resultStr->" + resultStr);
		} catch (Exception e) {
			System.out.println("SE_DaoImpl likeCheck Exception->" + e.getMessage());
		}
		
		
		return resultStr;
	}

	@Override
	public int insertLike(Map<String, Object> map) {
		System.out.println("SE_DaoImpl insertLike Start ...");
		int result = 0;
		try {
			result= session.insert("SE_InsertMovieLike", map);
			System.out.println("SE_DaoImpl insertLike resultStr->" + result);
		} catch (Exception e) {
			System.out.println("SE_DaoImpl insertLike Exception->" + e.getMessage());
		}
		
		return result;
	}

	@Override
	public void updateLike(int mo_number) {
		try {
			 session.update("SE_UpdateLikeMovieLike", mo_number);
			System.out.println("SE_DaoImpl updateLike resultStr 성공->" );
		} catch (Exception e) {
			System.out.println("SE_DaoImpl updateLike Exception->" + e.getMessage());
		}
		
	}

	@Override
	public int deleteLike(Map<String, Object> map) {
		System.out.println("SE_DaoImpl deleteLike Start ...");
		int result = 0;
		try {
			result= session.delete("SE_DeleteMovieLike", map);
			System.out.println("SE_DaoImpl deleteLike resultStr->" + result);
		} catch (Exception e) {
			System.out.println("SE_DaoImpl deleteLike Exception->" + e.getMessage());
		}
		
		return result;
	}

	@Override
	public void updateLikeCancel(int mo_number) {
		try {
			 session.update("SE_UpdateLikeCancelMovieLike", mo_number);
			System.out.println("SE_DaoImpl updateLikeCancel resultStr 성공->" );
		} catch (Exception e) {
			System.out.println("SE_DaoImpl updateLikeCancel Exception->" + e.getMessage());
		}
	}

	@Override
	public Member findMember(String m) {
		Member member = null;
		System.out.println("SE_DaoImpl findMember Start ...");
		try {
			member = session.selectOne("SE_SelMember", m);
			System.out.println("SE_DaoImpl findMember getEname->" + member.getM_id());
		} catch (Exception e) {
			System.out.println("SE_DaoImpl findMember Exception->" + e.getMessage());
		}

		return member;
	}

	@Override
	public List<Movie> listRecommendMovie() {
		List<Movie> RecommendMovieList = null;
		System.out.println("SE_DaoImpl listRecommendMovie Start ...");
		try {
			RecommendMovieList = session.selectList("SE_SelReCoMovie");
			System.out.println("SE_DaoImpl movielist " + RecommendMovieList.size());
		} catch (Exception e) {
			System.out.println("SE_DaoImpl listMoive Exception->" + e.getMessage());
		}
		return RecommendMovieList;
	}

	

}
