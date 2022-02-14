package com.oracle.HomeTheater.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.HomeTheater.dao.SE_Dao;
import com.oracle.HomeTheater.model.Member;
import com.oracle.HomeTheater.model.Movie;
import com.oracle.HomeTheater.model.MovieLike;

@Service
public class SE_ServiceImpl implements SE_Service {
	@Autowired
	private SE_Dao sd;
	
	@Override
	public List<Movie> listMovie() {
		List<Movie> movieList = null;
		System.out.println("SE_ServiceImpl listMovie Start..." );
		movieList = sd.listMoive();
		System.out.println("movieList size ->  "+movieList.size());
		return movieList;
	}

	@Override
	public Movie movieDetail(int mo_number) {
		System.out.println("SE_ServiceImpl movieDetail Start..." );
		Movie movie = null;
		movie = sd.movieDetail(mo_number);
		return movie;
	}



	@Override
	public int likeCheck(Map<String, Object> map) {
		System.out.println("SE_ServiceImpl likeCheck Start..." );
		return sd.likeCheck(map);
	}

	@Override
	public int insertLike(Map<String, Object> map) {
		System.out.println("SE_ServiceImpl insertLike Start..." );
		int result = 0;
		result = sd.insertLike(map);
		return result;
	}

	@Override
	public void updateLike(int mo_number) {
		System.out.println("SE_ServiceImpl updateLike Start..." );
		sd.updateLike(mo_number);
	}

	@Override
	public int deleteLike(Map<String, Object> map) {
		System.out.println("SE_ServiceImpl deleteLike Start..." );
		int result = 0;
		result = sd.deleteLike(map);
		return result;
	}

	@Override
	public void updateLikeCancel(int mo_number) {
		System.out.println("SE_ServiceImpl updateLikeCancel Start..." );
		sd.updateLikeCancel(mo_number);
		
	}

	@Override
	public Member findMember(String m) {
		System.out.println("SE_ServiceImpl findMember Start..." );
		Member member = sd.findMember(m);
		
		return member;
	}

	@Override
	public List<Movie> listRecommendMovie() {
		List<Movie> movieList = null;
		System.out.println("SE_ServiceImpl listRecommendMovie Start..." );
		movieList = sd.listRecommendMovie();
		System.out.println("movieList size ->  "+movieList.size());
		return movieList;
	}

	
}
