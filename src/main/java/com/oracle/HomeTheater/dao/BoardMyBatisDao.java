package com.oracle.HomeTheater.dao;

import java.util.List;

import com.oracle.HomeTheater.model.Board;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class BoardMyBatisDao implements BoardDao {

	
	@Autowired
	private SqlSession	session;
	
	//YM_게시판 글 수 조회
	@Override
	
	public int total(Board Board) {
		int tot = 0;
		System.out.println("YM_DaoImpl Start total..." );
		
		// Result = > 14
		try {
			tot = session.selectOne("YM_TotalBoard", Board);
			System.out.println("YM_DaoImpl total tot->"+tot );
			
		} catch (Exception e) {
			System.out.println("YM_DaoImpl total Exception->"+e.getMessage());
		}
		return tot;
	}
	
	//YM_공지사항 리스트 조회
	@Override
	public List<Board> listBoard(Board Board) {
		List<Board> BoardList = null;
		System.out.println("YM_DaoImpl Start BoardList Start..." );
		try {			
			BoardList = session.selectList("YM_SelectListBoard", Board);
			
		} catch (Exception e) {
			System.out.println("YM_DaoImpl Noticelist Exception->"+e.getMessage());	
		}
		
		return BoardList;
	}

	//noticeContents 공지사항 글 내용 보기
	@Override
	public Board noticeContents(Board Board) {
		Board BoardContents =null;
		System.out.println("YM_DaoImpl Start noticeContents..." );
		try {
			BoardContents = session.selectOne("YM_ClickTitleBoard", Board);

			
			try {  
				//조회수 증가 시퀀스

				session.update("YM_ClickTitleCntHitBoard", Board);
				
			} catch (Exception e) {
				System.out.println("YM_DaoImpl noticeContents YM_ClickTitleCntHitBoard Exception->"+e.getMessage());	

			}
			
		} catch (Exception e) {
			System.out.println("YM_DaoImpl noticeContents Exception->"+e.getMessage());	
		}
		return BoardContents;
	}

//YM_noticeWrite 글 내용 작성하기
	@Override
	public int noticeWrite(Board Board) {
		int result = 0;
		System.out.println("YM_DaoImpl noticeWrite  start.......->");	
		try {

			result = session.insert("YM_InsertBoard", Board);

		} catch (Exception e) {
			System.out.println("YM_DaoImpl noticeWrite Exception->"+e.getMessage());
		}
		
		return result;
		
		
	}


//YM_contentsDelete 글 삭제 하기
	@Override
	public int contentsDelete(Board Board) {
		System.out.println("YM_DaoImpl contentsDelete  start.......");
		int BoardContentsDelete=0;
		try {
			BoardContentsDelete  = session.delete("YM_DeleteBoard", Board);
		} catch (Exception e) {
			System.out.println("YM_DaoImpl contentsDelete Exception->"+e.getMessage());
		}
		
		return BoardContentsDelete;
	}

//YM_contentsUpdate
	@Override
	public int contentsUpdate(Board Board) {
		int BoardContentsUpdate=0;
		System.out.println("YM_DaoImpl contentsUpdate start.......");
		try {


			BoardContentsUpdate=session.update("YM_UpdateBoard", Board);
		} catch (Exception e) {
			System.out.println("YM_DaoImpl contentsUpdate Exception->"+e.getMessage());
		}
		return BoardContentsUpdate;
	}

	@Override
	public Page<Board> listBoardJpa(Pageable pageable, Board board) {
		return null;
	}


}