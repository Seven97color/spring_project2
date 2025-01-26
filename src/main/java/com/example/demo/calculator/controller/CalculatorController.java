package com.example.demo.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.calculator.service.CalculatorService;

@Controller
public class CalculatorController {

	private final CalculatorService calculatorService;

	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	@GetMapping("calculator")
	public String calculator(Model model) {

		return "calculator.html";//calculator.htmlに画面遷移

	}

	@PostMapping("calculator")
	public String calculator(@RequestParam("example") String example, @RequestParam("text1") String str1,
			@RequestParam("text2") String str2, Model model) {

		model.addAttribute("result", calculatorService.calculator(example,str1, str2));
		return "calculator.html";//calculator.htmlに画面遷移
	}
}