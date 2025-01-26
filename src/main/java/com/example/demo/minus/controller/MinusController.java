package com.example.demo.minus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.minus.service.MinusService;

@Controller
public class MinusController {

	private final MinusService minusService;

	public MinusController(MinusService minusService) {
		this.minusService = minusService;
	}

	@GetMapping("minus")
	public String minus(Model model) {

		return "minus.html";//minus.htmlに画面遷移
	
	}

	@GetMapping("minus1")
	public String minus(Model model, @RequestParam("text1") String str1, @RequestParam("text2") String str2) {

		model.addAttribute("result", minusService.minus(str1, str2));
		
		return "minus.html";//minus.htmlに画面遷移
	
	}
//
//	@PostMapping("minus1")
//	public String minus(Model model, @RequestParam("text1") int int1, @RequestParam("text2") int int2) {
//
//		model.addAttribute("result", minusService.minus(int1, int2));
//
//		return "minus.html";//minus.htmlに画面遷移
//
//	}
}
