package com.oracle.HomeTheater.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paging {
	private int currentPage = 1;	private int rowPage = 10;
	private int pageBlock = 10;
	private int start;					private int end;
	private int startPage;				private int endPage;
	private int total;				private int totalPage;
	//               12                  1
	public Paging(int total, String currentPage1) {
		this.total = total;
		if(currentPage1 != null) {
			this.currentPage = Integer.parseInt(currentPage1);     	
		}
		//				1				5
		start = (currentPage - 1) * rowPage + 1;   // 1
		//			1		5
		end	  = start + rowPage - 1;  //5             
		// 									12			5
		totalPage = (int) Math.ceil((double)total / rowPage);  // 3
		//				1				1				10
		startPage = currentPage - (currentPage - 1) % pageBlock;  // 1
		//				1			10
		endPage   = startPage + pageBlock - 1;   // 10
		//		10		3
		if(endPage > totalPage) {
			endPage = totalPage;                  // 3
		}
	}
	
	
	
	

}
