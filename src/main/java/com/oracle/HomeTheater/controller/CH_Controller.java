package com.oracle.HomeTheater.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.HomeTheater.model.Bbs;
import com.oracle.HomeTheater.model.ChoiceMovie;
import com.oracle.HomeTheater.model.Member;
import com.oracle.HomeTheater.model.Movie;
import com.oracle.HomeTheater.model.Reservation;
import com.oracle.HomeTheater.model.SeatandTime;
import com.oracle.HomeTheater.service.CH_Service;


@Controller
public class CH_Controller {
	@Autowired
	private CH_Service cs;

	@RequestMapping(value = "main")
	public String main(Bbs bbs, Model model) {
		System.out.println("CH_Contorller main Start...");
		List<Bbs> mainBbsList = cs.mainBbsList(bbs);
		model.addAttribute("mainBbsList",mainBbsList);
		return "main";
	}
	
	@RequestMapping(value = "CH_Payment")
	public String CH_Payment() {
		System.out.println("CH_Contorller CH_Payment Start...");
		return "CH_view/CH_Payment";
	}
	
	// 통합검색
	@GetMapping(value="SearchTotalList")
	public String list(Movie movie, Bbs bbs, Model model) {
		System.out.println("CH_Contorller SearchTotalList Start list...");
		List<Movie> SearchMovieList = cs.SearchMovieList(movie);
		List<Bbs> SearchBbsList = cs.SearchBbsList(bbs);
		model.addAttribute("SearchMovieList",SearchMovieList);
		model.addAttribute("SearchBbsList",SearchBbsList);
		
		return "CH_view/CH_SearchTotalList";
	}
	
	// 회원정보
	@RequestMapping(value = "modifyForm")
	public String modify(Member member, Model model, HttpSession session) {
		System.out.println("CH_Contorller modifyForm Start...");
		String m_id = (String)session.getAttribute("sessionId");
		member = cs.searchUserInfo(m_id);
		model.addAttribute("member",member);
		return "CH_view/CH_ModifyMember";
	}
	
	// 회원수정
	@PostMapping(value = "memberUpdate")
	public String memberUpdate(Member member, Model model, HttpSession session) {
		System.out.println("CH_Contorller memberUpdate Start...");
		int update = cs.memberUpdate(member);
		model.addAttribute("update",update);
		session.setAttribute("userName", member.getM_name());
		model.addAttribute("userName",member.getM_name());
		return "forward:/myPage";
	}
	
	// 비밀번호 수정
	@PostMapping(value = "memberPwUpdate")
	public String memberPwUpdate(Member member, Model model, HttpSession session, @RequestParam("m_newPassword") String m_newPassword) {
		System.out.println("CH_Contorller memberPwUpdate Start...");
		String m_password = m_newPassword;
		member.setM_password(m_password);
		int update = cs.memberPwUpdate(member);
		model.addAttribute("update",update);
		session.setAttribute("userName", member.getM_name());
		model.addAttribute("userName",member.getM_name());
		return "forward:/myPage";
	}
		
	// 회원탈퇴
	@RequestMapping(value = "memberDelete")
	public String memberDelete(Model model, HttpSession session) {
		System.out.println("CH_Contorller memberDelete Start...");
		String m_id = (String)session.getAttribute("sessionId");
		int result = cs.memberDelete(m_id);
		session.invalidate();
		return "main";
	}
	
	// 아이디 중복체크
	@PostMapping(value = "idCheck")
	@ResponseBody
	public int idCheck(@RequestParam("m_id") String m_id) {
		System.out.println("CH_Contorller idCheck Start...");
		int cnt = cs.idCheck(m_id);
		return cnt;
	}
	
	// 전화번호 중복체크
	@PostMapping(value = "emailCheck")
	@ResponseBody
	public int phoneCheck(@RequestParam("phone1") String phone1, @RequestParam("phone2") String phone2, @RequestParam("phone3") String phone3) {
		System.out.println("CH_Contorller phoneCheck Start...");
		String m_phonenumber = phone1 + "-" + phone2 + "-" + phone3;
		System.out.println("전화번호="+m_phonenumber);
		int cnt = cs.phoneCheck(m_phonenumber);
		return cnt;
	}
	
	// 비밀번호 찾기 폼
	@GetMapping(value = "findPwForm")
	public String findPwForm() {
		System.out.println("CH_Contorller findPwForm Start...");
		return "CH_view/CH_FindPw";
	}
	
	// 본인이메일 확인(비밀번호찾기용)
	@PostMapping(value = "checkEmail_Pw")
	@ResponseBody
	public String checkEmail_Pw(@RequestParam("m_id") String m_id, @RequestParam("m_email") String m_email) {
		System.out.println("CH_Contorller checkEmail_Pw Start...");
		String result = cs.checkEmail_Pw(m_id);
		
		if(m_email.equals(result)) {
			System.out.println("result="+result);
			return result;
		}else {
			result = null;
		}
		return result;
	}
	
	// 본인이메일 확인(아이디찾기용)
	@PostMapping(value = "checkEmail_Id")
	@ResponseBody
	public String checkEmail_Id(@RequestParam("m_phonenumber") String m_phonenumber, @RequestParam("m_email") String m_email) {
		System.out.println("CH_Contorller checkEmail_Id Start...");	
		String result = cs.checkEmail_Id(m_phonenumber);
		if(m_email.equals(result)) {
			System.out.println("result="+result);
			return result;
		}else {
			result = null;
		}
		return result;
	}
	
	// 아이디 찾기 폼
	@GetMapping(value = "findIdForm")
	public String findIdForm() {
		System.out.println("CH_Contorller findIdForm Start...");
		return "CH_view/CH_FindId";
	}
	
	// 관심영화
	@GetMapping(value = "interestMovie")
	public String findInterstMovie(ChoiceMovie choice, Movie movie, Model model, HttpSession session) {
		System.out.println("CH_Contorller findInterstMovie Start...");	
		// session에서 id를 꺼내옴
		String m_id = (String)session.getAttribute("sessionId");
		// 현재 세션아이디로 m_id 설정
		choice.setM_id(m_id);
		// id에 찜한 영화 mo_number 가져오기
		List<ChoiceMovie> GetMoNumList = cs.getMoNumList(choice);
		// 반복문을 돌려 얻어낸 영화정보를 저장할 List(addAll을 사용하기위해 arrayList로 선언)
		ArrayList<Movie> TotalList = new ArrayList<Movie>();
		
		List<Movie> InterestMovieList = null;
		// 반복문을 통해서 GetMoNumList값 추출후 TotalList로 옮겨주는 작업
		for(int i=0;i<GetMoNumList.size();i++) {
			String moNumber = String.valueOf(GetMoNumList.get(i));
			int mo_number = Integer.parseInt(moNumber);	
			movie.setMo_number(mo_number);
			InterestMovieList = cs.InterestMovieList(movie);
			TotalList.addAll(InterestMovieList);
		}
		model.addAttribute("TotalList",TotalList);
		return "CH_view/CH_InterestMovie";
	}
	
	// 예약정보
	@GetMapping(value = "reservationInfo")
	public String reservationInfoForm(Movie movie, Reservation reservation, SeatandTime seatTime, Model model, HttpSession session) {
		System.out.println("CH_Contorller reservationInfoForm Start...");
		String m_id = (String)session.getAttribute("sessionId");
		reservation.setM_id(m_id);
		seatTime.setM_id(m_id);
		List<Reservation> checkReservationInfo = cs.checkReservationInfo(reservation);
		List<SeatandTime> searchSeatInfo = cs.searchSeatInfo(seatTime);
		model.addAttribute("checkReservationInfo",checkReservationInfo);
		model.addAttribute("searchSeatInfo",searchSeatInfo);	
		return "CH_view/CH_ReservationInfo";
	}
	
	// 관리자 회원리스트
	@RequestMapping(value = "memberList")
	public String memberList(Member member, Model model) {
		System.out.println("CH_Contorller memberList Start...");
		List<Member> memberList = cs.memberList(member);
		model.addAttribute("memberList",memberList);
		return "CH_view/CH_MemberManagement";
	}
	
	// 관리자 회원수정
	@PostMapping(value = "adminUpdateMember")
	@ResponseBody
	public int adminUpdateMember(Member member,Model model) {
		System.out.println("CH_Contorller memberUpdate Start...");
		int update = cs.adminUpdateMember(member);
		return update;
	}
	
	// 관리자 회원삭제
	@GetMapping(value = "adminDeleteMember")
	@ResponseBody
	public int adminDeleteMember(@RequestParam("m_id") String m_id) {
		int delete = cs.memberDelete(m_id);
		return delete;
	}
	
	// 관리자 예약리스트
	@RequestMapping(value = "reservationList")
	public String reservationList(Reservation reservation, Model model) {
		System.out.println("CH_Contorller reservationList Start...");
		List<Reservation> reservationList = cs.reservationList(reservation);
		model.addAttribute("reservationList",reservationList);
		return "CH_view/CH_ReservationList";
	}
	
	// 관리자 예매수정
	@PostMapping(value = "adminUpdateReservation")
	@ResponseBody
	public int adminUpdateReservation(Reservation reservation) {
		System.out.println("CH_Contorller adminUpdateReservation Start...");
		// 외래키 담은 테이블 수정할때 제약조건 에러 발생 -> 오라클에서 alter table 테이블명 drop  CONSTRAINT SYS_번호; 하면 제약조건 삭제가능
		int update = cs.adminUpdateReservation(reservation);
		return update;
	}
	
	
}
