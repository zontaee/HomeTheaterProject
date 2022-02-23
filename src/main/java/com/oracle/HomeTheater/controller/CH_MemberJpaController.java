package com.oracle.HomeTheater.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oracle.HomeTheater.domain.MemberJpa;
import com.oracle.HomeTheater.service.CH_MemberJpaService;

@Controller
public class CH_MemberJpaController {
	private final CH_MemberJpaService memberJpaService;
	
	@Autowired
	public CH_MemberJpaController(CH_MemberJpaService memberJpaService) {
		this.memberJpaService = memberJpaService;
	}
	
	// 이용약관 폼
	@GetMapping(value = "terms")
	public String terms() {
		System.out.println("CH_MemberJpaController terms Start...");
		return "CH_view/CH_Terms";
	}

	// 회원가입 폼 
	@GetMapping(value = "joinMember")
	public String joinUserForm() {
		System.out.println("CH_MemberJpaController joinUserForm Start...");
		return "CH_view/CH_JoinMember";
	}
	
	// 회원가입
	@RequestMapping(value = "joinMember/save")
	public String joinUser(MemberJpa member,@RequestParam("phone1") String phone1, @RequestParam("phone2") String phone2, @RequestParam("phone3") String phone3,
			@RequestParam("mail1") String mail1, @RequestParam("mail2") String mail2, @RequestParam("zipcode") String zipcode, @RequestParam("roadAddress") String roadAddress,
			@RequestParam("jibunAddress") String jibunAddress, @RequestParam("detailAddress") String detailAddress, @RequestParam("extraAddress") String extraAddress, Model model) {
		System.out.println("CH_MemberJpaController joinMember/save Start...");
		String m_phonenumber = phone1 + "-" + phone2 + "-" + phone3;
		String m_email = mail1 + "@" + mail2;
		String m_address = zipcode + roadAddress + jibunAddress + detailAddress + extraAddress;
		member.setM_address(m_address);
		member.setM_email(m_email);
		member.setM_phonenumber(m_phonenumber);
		memberJpaService.joinUser(member);
		return "redirect:/loginForm";
	}
	
	// 로그인 폼
	@GetMapping(value="loginForm")
	public String loginForm() {
		System.out.println("CH_MemberJpaController loginForm Start...");
		return "CH_view/CH_Login";
	}

	// 로그인
	@PostMapping(value = "login")
	public String login(MemberJpa member, Model model, HttpServletRequest request, HttpSession session, HttpServletResponse response) {
		String sessionUrl = String.valueOf(session.getAttribute("sessionUrl")).substring(1);
		System.out.println("sessionUrl =" + sessionUrl);
		session.invalidate();
		MemberJpa memberVO = memberJpaService.loginUser(member.getM_id(), member.getM_password());

		if (memberVO == null) {
			model.addAttribute("loginMessage", "아이디 혹은 비밀번호가 틀립니다.");
			return "CH_view/CH_Login";
		}
		// 로그인 성공 처리
		// 세션이 있으면 있는 세션 반환, 없으면 신규 세션 생성
		session = request.getSession();

		// 로그인 세션 유지를 위해 header부분에 있는 userName으로 세션 저장
		session.setAttribute("userName", memberVO.getM_name());
		session.setAttribute("sessionId", memberVO.getM_id());
		model.addAttribute("sessionId", memberVO.getM_id());
		model.addAttribute("userName", memberVO.getM_name());
		if (sessionUrl.equals("ull")) {
			return "forward:/main";
		}else {
			//인터셉터 후 로그인 페이지
			System.out.println("forward");
			model.addAttribute("sessionUrl",sessionUrl);
			return "redirectpage";
		}
	}
	
	// 로그아웃
	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest request) {
		System.out.println("CH_MemberJpaController logout Start...");
		HttpSession session = request.getSession();
		session.invalidate();
		return "CH_view/CH_Login";
	}

	// 마이페이지 폼
	@RequestMapping(value = "myPage")
	public String myPage(HttpSession session) {
		System.out.println("CH_MemberJpaController myPage Start...");
		String m_id = (String)session.getAttribute("sessionId");
		if(m_id == null) {
			return "CH_view/CH_Login";
		}
		return "CH_view/CH_MyPage";
	}
	
	
	
}