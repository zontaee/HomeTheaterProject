package com.oracle.HomeTheater.service;


import java.util.List;



import com.oracle.HomeTheater.model.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BoardService {
	 int           total(Board board);
	 List<Board>     listboard(Board board);
	 Board noticeContents(Board board);
	 int 		   noticeWrite(Board board, String loginMember);
	 int           contentsDelete(Board board);
	 int           contentsUpdate(Board board);


    Page<Board> listboardJpa(Pageable pageable, Board board);
}