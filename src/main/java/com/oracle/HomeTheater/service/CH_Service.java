package com.oracle.HomeTheater.service;

import java.util.List;

import com.oracle.HomeTheater.model.Bbs;
import com.oracle.HomeTheater.model.Movie;


public interface CH_Service {

	List<Movie> SearchMovieList(Movie movie);
	List<Bbs> SearchBbsList(Bbs bbs);



}
