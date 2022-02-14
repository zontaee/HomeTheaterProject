package com.oracle.HomeTheater.controller;


import java.util.List;

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
import com.oracle.HomeTheater.service.CH_Service;


@Controller
public class CH_Controller {
    @Autowired
    private CH_Service cs;

    @RequestMapping(value = "main")
    public String main() {
        System.out.println("CH_Contorller main Start...");
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
        System.out.println("CH_Contorller SearchMovieList.size()=>"+SearchMovieList.size());
        System.out.println("CH_Contorller SearchBbsList.size()=>"+SearchBbsList.size());
        model.addAttribute("SearchMovieList",SearchMovieList);
        model.addAttribute("SearchBbsList",SearchBbsList);

        return "CH_view/CH_SearchTotalList";
    }

    // 회원정보
    @RequestMapping(value = "modifyForm")
    public String modify(Member member, Model model, HttpSession session) {
        System.out.println("CH_Contorller modifyForm Start...");
        System.out.println("현재 세션아이디="+session.getAttribute("sessionId"));
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

    // 로그인 아이디에 맞는 관심영화 찾기
    @GetMapping(value = "findInterstMovie")
    public String findInterstMovie(ChoiceMovie choice, Movie movie, Model model, HttpSession session) {
        System.out.println("CH_Contorller findInterstMovie Start...");
        String m_id = (String)session.getAttribute("sessionId");
        System.out.println("m_id="+m_id);
        // 현재 세션아이디로 m_id 설정
        choice.setM_id(m_id);
        // id에 찜한 영화 mo_number 가져오기
        List<ChoiceMovie> GetMoNumList = cs.GetMoNumList(choice);
        System.out.println("number="+GetMoNumList);

        for(int i=0;i<GetMoNumList.size();i++) {
            List<ChoiceMovie> mo_number = GetMoNumList;
            System.out.println("number="+mo_number);
        }
        List<Movie> InterestMovieList = cs.InterestMovieList(movie);
        System.out.println("영화목록="+InterestMovieList);


        return "CH_view/CH_InterestMovie";
    }
    // 관심영화 폼
    @GetMapping(value = "interestForm")
    public String interestForm() {
        System.out.println("CH_Contorller findIdForm Start...");
        return "CH_view/CH_InterstMovie";
    }
}