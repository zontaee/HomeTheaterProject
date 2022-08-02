package com.oracle.HomeTheater.dao;

import java.util.List;

import com.oracle.HomeTheater.model.Board;

public interface BoardDao {
	
	int 			total(Board Board);
	List<Board>       listBoard(Board Board);
	Board noticeContents(Board Board);
	int 			noticeWrite(Board Board);
	int 			contentsDelete(Board Board);
	int             contentsUpdate(Board Board);
	
}