package com.oracle.HomeTheater.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.HomeTheater.model.Bbs;
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








	
	


	
}
