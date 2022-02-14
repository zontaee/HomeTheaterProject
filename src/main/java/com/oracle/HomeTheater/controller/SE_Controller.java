package com.oracle.HomeTheater.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.HomeTheater.model.Member;
import com.oracle.HomeTheater.model.Movie;
import com.oracle.HomeTheater.model.MovieLike;
import com.oracle.HomeTheater.service.SE_Service;

@Controller
public class SE_Controller {
	HttpSession session;

	@Autowired
	private SE_Service ses;

	@GetMapping("/username")
	@ResponseBody
	public String currentUserName(Principal principal) {
		return principal.getName();
	}



	@RequestMapping(value = "movieList")
	public String movieList(Model model) {
		System.out.println("SE_Contorller main Start...");
		List<Movie> listMovie = ses.listMovie();
		model.addAttribute("listMovie", listMovie);
		return "SE_views/SE_movieList";
	}

	@RequestMapping(value = "movieDetail")
	public String movieDetail(int mo_number, Model model) {
		System.out.println("SE_Contorller movieDetail Start...");
		String m = "test1";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mo_number", mo_number);
		map.put("m_id", m);
		Movie movie = ses.movieDetail(mo_number);
		Member member = ses.findMember(m);
		int check = ses.likeCheck(map);
		System.out.println("check-> : " + check);
		model.addAttribute("check", check);

		model.addAttribute("movie", movie);
		model.addAttribute("member", member);

		// 좋ㅇ요 기능 추가

		return "SE_views/SE_movieDetail";
	}

	/*
	 * @RequestMapping(value = "likeCheck", produces =
	 * "application/text;chraset=utf-8") public String likeCheck(int mo_number,
	 * String m_id, Model model) {
	 * System.out.println("SE_Contorller likeCheck Start..."); Map<String, Object>
	 * map = new HashMap<String, Object>(); map.put("mo_number", mo_number);
	 * map.put("m_id", m_id); int check = ses.likeCheck(map);
	 * System.out.println("check-> : " + check); model.addAttribute("check", check);
	 * 
	 * return "SE_views/SE_movieDetail"; }
	 */
	@RequestMapping(value = "/updateLike", method = RequestMethod.POST)
	@ResponseBody
	public int updateLike(@RequestParam Map<String, Object> param) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mo_number", param.get("mo_number"));
		map.put("m_id", param.get("m_id"));
		int check = ses.likeCheck(map);
		int delState;
		int insState;
		if (check == 0) {
			// 좋아요 처음누름
			insState = ses.insertLike(map); // like테이블 삽입
			ses.updateLike(Integer.valueOf((String) param.get("mo_number"))); // 게시판테이블 +1

		} else if (check == 1) {

			ses.updateLikeCancel(Integer.valueOf((String) param.get("mo_number"))); // 게시판테이블 - 1
			delState = ses.deleteLike(map); // like테이블 삭제

		}
		return check;
	}
	
	@RequestMapping(value = "movieRecommendList")
	public String movieRecommendList(Model model) {
		System.out.println("SE_Contorller movieRecommendList Start...");
		List<Movie> listRecommendMovie = ses.listRecommendMovie();
		model.addAttribute("listRecommendMovie", listRecommendMovie);
		return "SE_views/SE_movieRecommendList";
	}
}
