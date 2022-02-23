package com.oracle.HomeTheater.service;


import java.util.List;



import com.oracle.HomeTheater.model.Bbs;


public interface YM_Service {
	 int           total(Bbs bbs);
	 List<Bbs>     listBbs(Bbs bbs);
	 Bbs           noticeContents(Bbs bbs);
	 int 		   noticeWrite(Bbs bbs);
	 int           contentsDelete(Bbs bbs);
	 int           contentsUpdate(Bbs bbs);
	 
	

}