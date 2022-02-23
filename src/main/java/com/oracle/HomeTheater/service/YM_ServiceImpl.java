package com.oracle.HomeTheater.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.HomeTheater.dao.YM_Dao;
import com.oracle.HomeTheater.model.Bbs;


@Service
public class YM_ServiceImpl implements YM_Service {
	
	@Autowired
	private  YM_Dao	ymDao;
	
	
	@Override
	public int total(Bbs bbs) {
		System.out.println("YM_ServiceImpl Start total..." );
		int totCnt = ymDao.total(bbs);
		System.out.println("YM_ServiceImpl total totCnt->"+totCnt );
		return totCnt;
	}


	@Override
	public List<Bbs> listBbs(Bbs bbs) {
		List<Bbs> bbsList = null;
		System.out.println("YM_ServiceImpl bbsList Start..." );
		bbsList = ymDao.listBbs(bbs);
		System.out.println("YM_ServiceImpl ListBbs bbsList.size()->" + bbsList.size());
		System.out.println("YM_ServiceImpl ListBbs bbs.getBbs_category()->" + bbs.getBbs_category());
		
		return bbsList;
	}

	@Override
	public Bbs noticeContents(Bbs bbs) {
		System.out.println("YM_ServiceImpl Start noticeContents..." );
		
		Bbs bbsContents = ymDao.noticeContents(bbs);
		System.out.println("YM_ServiceImpl noticeContents bbsContemts.getBbs_no, getBbs_category, getBbs_hit ->"
													+bbsContents.getBbs_no() +","+bbsContents.getBbs_category()+","+bbsContents.getBbs_hit());

			return bbsContents;
	}


	@Override
	public int noticeWrite(Bbs bbs) {
		int result = 0;
		System.out.println("YM_ServiceImpl noticeWrite start......");
		result=ymDao.noticeWrite(bbs);
		
		return result;
	}

	@Override
	public int contentsDelete(Bbs bbs) {
		System.out.println("YM_ServiceImpl contentsDelete start......");
		int bbsContentsDelete = ymDao.contentsDelete(bbs);
		
		return bbsContentsDelete;
	}


	@Override
	public int contentsUpdate(Bbs bbs) {
		System.out.println("YM_ServiceImpl contentsUpdate start......");
		int bbsContentsUpdate = ymDao.contentsUpdate(bbs);
		
		return bbsContentsUpdate;
	}

		
	



}