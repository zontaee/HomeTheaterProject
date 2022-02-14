package com.oracle.HomeTheater.dao;

import java.util.List;
import java.util.Map;

import com.oracle.HomeTheater.model.Member;
import com.oracle.HomeTheater.model.Movie;
import com.oracle.HomeTheater.model.MovieLike;

public interface SE_Dao {

	List<Movie> listMoive();

	Movie movieDetail(int mo_number);


	int likeCheck(Map<String, Object> map);

	int insertLike(Map<String, Object> map);

	void updateLike(int mo_number);

	int deleteLike(Map<String, Object> map);

	void updateLikeCancel(int mo_number);

	Member findMember(String m);

	List<Movie> listRecommendMovie();


}
