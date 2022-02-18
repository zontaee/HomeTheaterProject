package com.oracle.HomeTheater.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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

	/*
	 * @RequestMapping(value = "main") public String main() {
	 * System.out.println("SE_Contorller main Start..."); return "main"; }
	 */

	@RequestMapping(value = "movieList") // 영화 목록
	public String movieList(HttpServletRequest request, Model model) {
		System.out.println("SE_Contorller main Start...");

		List<Movie> listMovie = ses.listMovie();
		model.addAttribute("listMovie", listMovie);
		return "SE_views/SE_movieList";
	}

	@RequestMapping(value = "movieDetail") // 영화 상세보기
	public String movieDetail(int mo_number, HttpServletRequest request, Model model) {
		System.out.println("SE_Contorller movieDetail Start...");
		HttpSession session = request.getSession();
		String m_id = (String) session.getAttribute("sessionId");
		System.out.println(m_id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mo_number", mo_number);
		map.put("m_id", m_id);
		Movie movie = ses.movieDetail(mo_number);
		Member member = ses.findMember(m_id);
		int check = ses.likeCheck(map);
		System.out.println("check-> : " + check);
		model.addAttribute("check", check);

		model.addAttribute("movie", movie);
		model.addAttribute("member", member);

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

	// 영화 추천 버튼 누를 시 작동
	@RequestMapping(value = "/updateLike", method = RequestMethod.POST)
	@ResponseBody
	public int updateLike(@RequestParam Map<String, Object> param) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mo_number", param.get("mo_number"));
		map.put("m_id", param.get("m_id"));
		int check = ses.likeCheck(map); // movieLike 테이블에 해당 회원 아이디와 영화 번호를 가진 칼럼이 있는지 확인 있으면 1 없으면 0
		int delState;
		int insState;
		if (check == 0) {
			// check가 0이면 좋아요 처음누름
			insState = ses.insertLike(map); // like테이블 삽입
			ses.updateLike(Integer.valueOf((String) param.get("mo_number"))); // 게시판테이블 +1

		} else if (check == 1) {

			ses.updateLikeCancel(Integer.valueOf((String) param.get("mo_number"))); // 게시판테이블 - 1
			delState = ses.deleteLike(map); // like테이블 삭제

		}
		return check;
	}

	// 영화 추천수에 따라 리스트 출력
	@RequestMapping(value = "movieRecommendList")
	public String movieRecommendList(Model model) {
		System.out.println("SE_Contorller movieRecommendList Start...");
		List<Movie> listRecommendMovie = ses.listRecommendMovie();
		model.addAttribute("listRecommendMovie", listRecommendMovie);
		return "SE_views/SE_movieRecommendList";
	}

	// 관리자 영화 등록 페이지
	@RequestMapping(value = "adminMovieAddForm")
	public String adminMovieAddForm(Model model) {
		System.out.println("SE_Contorller adminMovieAddForm Start...");

		return "SE_views/SE_adminMovieAddForm";
	}

	// 관리자 영화 등록
	@RequestMapping(value = "adminMovieAdd", method = RequestMethod.POST)
	public String adminMovieAdd(Movie movie, MultipartFile file, Model model) {
		System.out.println("SE_Contorller adminMovieAdd Start...");
		//영화 이미지 업로드
		String savePath="D:\\project\\HomeTheater\\src\\main\\resources\\static\\";
		movie.setMo_fileName("Img/"+file.getOriginalFilename());
		System.out.println("SE_Contorller adminMovieAdd Start..." + movie.getMo_fileName());
		Path filePath = Paths.get(savePath + movie.getMo_fileName());

		try {
			Files.write(filePath, file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int result = ses.adminMovieAdd(movie);


		// 결과가 1이면 성공, 0이면 실패
		if (result > 0) {
			System.out.println("성공");
			return "redirect:movieList";
		} else {
			System.out.println("실패");
			model.addAttribute("msg", "입력 실패 확인해 보세요");
			return "forward:adminMovieAddForm";
		}

	}

	@GetMapping(value="adminMovieUpdateForm")
	public String updateForm(int mo_number,Model model) {
		System.out.println("SE_Contorller Start adminMovieUpdateForm..." );
		Movie movie = ses.movieDetail(mo_number);
		model.addAttribute("movie",movie);

		return "SE_views/SE_adminMovieUpdateForm";
	}

	@PostMapping(value="adminMovieUpdate")
	public String adminMovieUpdate(Movie movie, Model model) {
		int uptCnt = ses.adminMovieUpdate(movie);
		System.out.println("ses.adminMovieUpdate(movie) Count-->"+uptCnt);

		return "forward:movieList";

	}

	@RequestMapping(value="adminMovieDelete")
	public String adminMovieDelete(int mo_number, Model model) {
		System.out.println("SE_Contorller Start adminMovieDelete..." );
		int result = ses.adminMovieDelete(mo_number);
		return "redirect:movieList";
	}
}