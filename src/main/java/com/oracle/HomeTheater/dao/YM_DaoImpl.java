package com.oracle.HomeTheater.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.HomeTheater.model.Bbs;

@Repository
public class YM_DaoImpl implements YM_Dao {

	
	@Autowired
	private SqlSession	session;
	
	//YM_게시판 글 수 조회
	@Override
	
	public int total(Bbs bbs) {
		int tot = 0;
		System.out.println("YM_DaoImpl Start total..." );
		
		// Result = > 14
		try {
			tot = session.selectOne("YM_TotalBbs", bbs);
			System.out.println("YM_DaoImpl total tot->"+tot );
			
		} catch (Exception e) {
			System.out.println("YM_DaoImpl total Exception->"+e.getMessage());
		}
		return tot;
	}
	
	//YM_공지사항 리스트 조회
	@Override
	public List<Bbs> listBbs(Bbs bbs) {
		List<Bbs> bbsList = null;
		System.out.println("YM_DaoImpl Start bbsList Start..." );
		try {			
			bbsList = session.selectList("YM_SelectListBbs", bbs);			
			
		} catch (Exception e) {
			System.out.println("YM_DaoImpl Noticelist Exception->"+e.getMessage());	
		}
		
		return bbsList;
	}

	//noticeContents 공지사항 글 내용 보기
	@Override
	public Bbs noticeContents(Bbs bbs) {
		Bbs bbsContents=null;
		System.out.println("YM_DaoImpl Start noticeContents..." );
		try {
			bbsContents = session.selectOne("YM_ClickTitleBbs", bbs);
			System.out.println("YM_DaoImpl noticeContents getBbs_no ->"+bbs.getBbs_no());
			System.out.println("YM_DaoImpl noticeContents getBbs_category ->"+bbs.getBbs_category());
			System.out.println("YM_DaoImpl noticeContents getBbs_hit() ->"+bbs.getBbs_hit());
			System.out.println("YM_DaoImpl noticeContents bbsContemts.getBbs_no , getBbs_category ->"
												+bbsContents.getBbs_no()+","+bbsContents.getBbs_category());
			System.out.println("YM_DaoImpl noticeContents bbsContents.getBbs_date() ->"+bbsContents.getBbs_date());
			System.out.println("YM_DaoImpl noticeContents bbsContents.getBbs_title() ->"+bbsContents.getBbs_title());
			System.out.println("YM_DaoImpl noticeContents bbsContents.getBbs_content() ->"+bbsContents.getBbs_content());
			
			try {  
				//조회수 증가 시퀀스
				System.out.println("YM_DaoImpl noticeContents YM_ClickTitleCntHitBbs start  getBbs_category() ->"+bbs.getBbs_category());
				System.out.println("YM_DaoImpl noticeContents YM_ClickTitleCntHitBbs start  getBbs_no() ->"+bbs.getBbs_no());
				session.update("YM_ClickTitleCntHitBbs", bbs);
				
			} catch (Exception e) {
				System.out.println("YM_DaoImpl noticeContents YM_ClickTitleCntHitBbs Exception->"+e.getMessage());	
				System.out.println("YM_DaoImpl noticeContents YM_ClickTitleCntHitBbs  실패 getBbs_hit() ->"+bbs.getBbs_hit());
			}
			
		} catch (Exception e) {
			System.out.println("YM_DaoImpl noticeContents Exception->"+e.getMessage());	
		}
		return bbsContents;
	}

//YM_noticeWrite 글 내용 작성하기
	@Override
	public int noticeWrite(Bbs bbs) {
		int result = 0;
		System.out.println("YM_DaoImpl noticeWrite  start.......->");	
		try {
			System.out.println("YM_DaoImpl noticeWrite 세션전  getBbs_category->"+bbs.getBbs_category());
			result = session.insert("YM_InsertBbs", bbs);
			System.out.println("YM_DaoImpl noticeWrite 세션후  getBbs_category->"+bbs.getBbs_category());
		} catch (Exception e) {
			System.out.println("YM_DaoImpl noticeWrite Exception->"+e.getMessage());
		}
		
		return result;
		
		
	}


//YM_contentsDelete 글 삭제 하기
	@Override
	public int contentsDelete(Bbs bbs) {
		System.out.println("YM_DaoImpl contentsDelete  start.......");
		int bbsContentsDelete=0;
		try {
			bbsContentsDelete  = session.delete("YM_DeleteBbs",bbs);
		} catch (Exception e) {
			System.out.println("YM_DaoImpl contentsDelete Exception->"+e.getMessage());
		}
		
		return bbsContentsDelete;
	}

//YM_contentsUpdate
	@Override
	public int contentsUpdate(Bbs bbs) {
		int bbsContentsUpdate=0;
		System.out.println("YM_DaoImpl contentsUpdate start.......");
		try {
			System.out.println("YM_DaoImpl contentsUpdate bbs.getBbs_no()->"+bbs.getBbs_no());
			System.out.println("YM_DaoImpl contentsUpdate getBbs_category()->"+bbs.getBbs_category());
			System.out.println("YM_DaoImpl contentsUpdate bbs.getBbs_title()->"+bbs.getBbs_title());
			System.out.println("YM_DaoImpl contentsUpdate bbs.getBbs_content()->"+bbs.getBbs_content());

			bbsContentsUpdate=session.update("YM_UpdateBbs",bbs);
		} catch (Exception e) {
			System.out.println("YM_DaoImpl contentsUpdate Exception->"+e.getMessage());
		}
		return bbsContentsUpdate;
	}
	




	

	


}