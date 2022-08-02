package com.oracle.HomeTheater.service;

import java.util.List;

import com.oracle.HomeTheater.dao.BoardDao;
import com.oracle.HomeTheater.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao ymDao;
	
	
	@Override
	public int total(Board board) {
		System.out.println("YM_ServiceImpl Start total..." );
		int totCnt = ymDao.total(board);
		System.out.println("YM_ServiceImpl total totCnt->"+totCnt );
		return totCnt;
	}


	@Override
	public List<Board> listboard(Board board) {
		List<Board> boardList = null;
		System.out.println("YM_ServiceImpl boardList Start..." );
		boardList = ymDao.listBoard(board);
		System.out.println("YM_ServiceImpl Listboard boardList.size()->" + boardList.size());
		System.out.println("YM_ServiceImpl Listboard board.getboard_category()->" + board.getBoard_category());
		
		return boardList;
	}

	@Override
	public Board noticeContents(Board board) {
		System.out.println("YM_ServiceImpl Start noticeContents..." );
		
		Board boardContents = ymDao.noticeContents(board);
		System.out.println("YM_ServiceImpl noticeContents boardContemts.getboard_no, getboard_category, getboard_hit ->"
													+ boardContents.getBoard_no() +","+ boardContents.getBoard_category()+","+ boardContents.getBoard_hit());

			return boardContents;
	}


	@Override
	public int noticeWrite(Board board) {
		int result = 0;
		System.out.println("YM_ServiceImpl noticeWrite start......");
		result=ymDao.noticeWrite(board);
		
		return result;
	}

	@Override
	public int contentsDelete(Board board) {
		System.out.println("YM_ServiceImpl contentsDelete start......");
		int boardContentsDelete = ymDao.contentsDelete(board);
		
		return boardContentsDelete;
	}


	@Override
	public int contentsUpdate(Board board) {
		System.out.println("YM_ServiceImpl contentsUpdate start......");
		int boardContentsUpdate = ymDao.contentsUpdate(board);
		
		return boardContentsUpdate;
	}

		
	



}