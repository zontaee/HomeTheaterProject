package com.oracle.HomeTheater.service;

import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.HomeTheater.dao.MovieDao;
import com.oracle.HomeTheater.model.ChoiceMovie;
import com.oracle.HomeTheater.model.Member;
import com.oracle.HomeTheater.model.Movie;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieDao sd;
	
	@Override
	public List<Movie> listMovie() {
		List<Movie> movieList = null;
		log.info("SE_ServiceImpl listMovie Start..." );
		movieList = sd.listMoive();
		log.info("movieList size ->  "+movieList.size());
		return movieList;
	}

	@Override
	public Movie movieDetail(int mo_number) {
		log.info("SE_ServiceImpl movieDetail Start..." );
		Movie movie = null;
		movie = sd.movieDetail(mo_number);
		return movie;
	}



	@Override
	public int likeCheck(Map<String, Object> map) {
		log.info("SE_ServiceImpl likeCheck Start..." );
		return sd.likeCheck(map);
	}

	@Override
	public int insertLike(Map<String, Object> map) {
		log.info("SE_ServiceImpl insertLike Start..." );
		int result = 0;
		result = sd.insertLike(map);
		return result;
	}

	@Override
	public void updateLike(int mo_number) {
		log.info("SE_ServiceImpl updateLike Start..." );
		sd.updateLike(mo_number);
	}

	@Override
	public int deleteLike(Map<String, Object> map) {
		log.info("SE_ServiceImpl deleteLike Start..." );
		int result = 0;
		result = sd.deleteLike(map);
		return result;
	}

	@Override
	public void updateLikeCancel(int mo_number) {
		log.info("SE_ServiceImpl updateLikeCancel Start..." );
		sd.updateLikeCancel(mo_number);
		
	}

	@Override
	public Member findMember(String m) {
		log.info("SE_ServiceImpl findMember Start..." );
		Member member = sd.findMember(m);
		
		return member;
	}

	@Override
	public List<Movie> listRecommendMovie() {
		List<Movie> movieList = null;
		log.info("SE_ServiceImpl listRecommendMovie Start..." );
		movieList = sd.listRecommendMovie();
		log.info("movieList size ->  "+movieList.size());
		return movieList;
	}

	@Override
	public int adminMovieAdd(Movie movie) {
		log.info("SE_ServiceImpl adminMovieAdd Start..." );
		
		int result = 0;
		
		result = sd.adminMovieAdd(movie);

		return result;
	}

	@Override
	public int adminMovieUpdate(Movie movie) {
		log.info("SE_ServiceImpl adminMovieUpdate ...");
		int result = 0;
		result = sd.adminMovieUpdate(movie);
		return result;
	}

	@Override
	public int adminMovieDelete(int mo_number) {
	    log.info("SE_ServiceImpl adminMovieDelete ...");
		int result = 0;
		result = sd.adminMovieDelete(mo_number);
		return result;
	}

	@Override
	public ChoiceMovie findChoiceMovie(Map<String, Object> map) {
		log.info("SE_ServiceImpl findChoiceMovie Start..." );
		ChoiceMovie choiceMovie= sd.findChoiceMovie(map);

		return choiceMovie;
	}

	@Override
	public int CheckChoiceMovie(Map<String, Object> map) {
		log.info("SE_ServiceImpl CheckChoiceMovie Start..." );
		int check= sd.CheckChoiceMovie(map);
		return check;
	}

	@Override
	public int insertChoiceMovie(Map<String, Object> map) {
		log.info("SE_ServiceImpl insertChoiceMovie Start..." );
		int resulit= sd.insertChoiceMovie(map);
		return resulit;
	}

	@Override
	public int updateChoiceMovieCancle(Map<String, Object> map) {
		log.info("SE_ServiceImpl updateChoiceMovieCancle Start..." );
		int resulit= sd.updateChoiceMovieCancle(map);
		return resulit;
	}

	
}