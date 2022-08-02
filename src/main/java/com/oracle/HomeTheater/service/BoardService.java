package com.oracle.HomeTheater.service;


import java.util.List;



import com.oracle.HomeTheater.model.Board;


public interface BoardService {
	 int           total(Board board);
	 List<Board>     listboard(Board board);
	 Board noticeContents(Board board);
	 int 		   noticeWrite(Board board);
	 int           contentsDelete(Board board);
	 int           contentsUpdate(Board board);
	 
	

}