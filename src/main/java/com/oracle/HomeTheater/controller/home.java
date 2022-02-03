package com.oracle.HomeTheater.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class home {

	@RequestMapping("/")
	public String mainpage() {
		return "main";
	}
}
