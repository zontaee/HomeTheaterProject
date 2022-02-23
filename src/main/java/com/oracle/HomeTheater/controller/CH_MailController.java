package com.oracle.HomeTheater.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.HomeTheater.domain.MailDTO;
import com.oracle.HomeTheater.model.Member;
import com.oracle.HomeTheater.service.CH_MailService;
import com.oracle.HomeTheater.service.CH_Service;

@RestController
public class CH_MailController {
	@Autowired
	private CH_MailService mailService;
	@Autowired
	private CH_Service cs;
	
	// 비밀번호찾기(임시 비밀번호 생성)
	@GetMapping(value="sendTempPw")
	@ResponseBody
	public MailDTO sendMail_Pw(@RequestParam("m_id") String m_id, @RequestParam("m_email") String m_email, Member member, Model model) {
		System.out.println("CH_MailController sendMail Start...");
		
		MailDTO dto = new MailDTO();
		
		// 랜덤한 문자열 넣어주기
		String randomPw = RandomStringUtils.randomAlphanumeric(6);
		
		dto.setAddress(m_email);
		dto.setTitle("HomeTheater에서 발송한 이메일입니다.");
		dto.setMessage("아이디: ["+m_id+"]님의 임시비밀번호는 "+randomPw+" 입니다.\n개인정보 보호를 위해 로그인 후 비밀번호 변경을 해주세요!!");	
		mailService.sendMail(dto);
		
		// 임시비밀번호로 비밀번호 update
		String m_password = randomPw;
		member.setM_password(m_password);
		int update = cs.tempPasswrodUpdate(member);
		model.addAttribute("update",update);
		System.out.println("message="+dto.getMessage());
		return dto;
	}
	
	// 아이디찾기(인증번호 생성)
	@GetMapping(value="sendAuthenticationNum")
	@ResponseBody
	public String sendMail_Id(@RequestParam("m_phonenumber") String m_phonenumber, @RequestParam("m_email") String m_email) {
		System.out.println("CH_MailController sendMail_Id Start...");
		
		// 메일 내용에 이름을 넣어주고 싶어서 찾아옴
		String result = cs.findName(m_phonenumber);
		MailDTO dto = new MailDTO();
		
		// 랜덤한 문자열 넣어주기
		String randomPw = RandomStringUtils.randomAlphanumeric(6);
		
		dto.setAddress(m_email);
		dto.setTitle("HomeTheater에서 발송한 이메일입니다.");
		dto.setMessage("아이디 찾기에서 ["+result+"] 님이 요청하신 인증번호는 "+randomPw+" 입니다.\n아이디 찾기 화면에서 인증번호를 입력해주세요!!");	
		mailService.sendMail(dto);

		return randomPw;
	}
	
	// 인증번호 확인하기
	@GetMapping(value = "checkNum")
	@ResponseBody
	public String checkNum(@RequestParam("inputNum") String inputNum, @RequestParam("num") String num, @RequestParam("m_phonenumber") String m_phonenumber) {
		System.out.println("CH_MailController checkNum Start...");
		String id = null;
		System.out.println("num="+num);
		System.out.println("inpuNum="+inputNum);
		
		if(inputNum.equals(num)) {
			id = cs.findId(m_phonenumber);
			return id;
		}
		System.out.println("id="+id);
		return id;
	}
	
	
	
	
}
