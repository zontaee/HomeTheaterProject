package com.oracle.HomeTheater.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.HomeTheater.model.Bbs;
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
	
	/*@RequestMapping(value = "CH_Payment")
	public String CH_Payment() {
		System.out.println("CH_Contorller CH_Payment Start...");
		return "CH_view/CH_Payment";
	}*/

    @GetMapping(value = "SearchTotalList")
    public String list(Movie movie, Bbs bbs, Model model) {
        System.out.println("CH_Contorller SearchTotalList Start list...");
        List<Movie> SearchMovieList = cs.SearchMovieList(movie);
        List<Bbs> SearchBbsList = cs.SearchBbsList(bbs);
        System.out.println("CH_Contorller SearchMovieList.size()=>" + SearchMovieList.size());
        System.out.println("CH_Contorller SearchBbsList.size()=>" + SearchBbsList.size());
        model.addAttribute("SearchMovieList", SearchMovieList);
        model.addAttribute("SearchBbsList", SearchBbsList);

        return "CH_view/CH_SearchTotalList";
    }


}
