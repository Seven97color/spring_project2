package com.example.demo.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

		try {
			if (str1.isEmpty() || str2.isEmpty()) { //num1,num2が空かどうか確認する条件処理
				//条件がtrueの場合
				model.addAttribute("result", "何も入力されていません");
				return "calculator.html";
			} else {
				int int1 = Integer.parseInt(str1);
				int int2 = Integer.parseInt(str2);

				switch (example) {
				case "plus":
					model.addAttribute("result", calculatorService.calculator1(int1, int2));
					break;
				case "minus":
					model.addAttribute("result", calculatorService.calculator2(int1, int2));
					break;
				case "multi":
					model.addAttribute("result", calculatorService.calculator3(int1, int2));
					break;
				case "divide":
					model.addAttribute("result", calculatorService.calculator4(int1, int2));
					break;
				}
			}
			//例外が発生しうる処理
		} catch (NumberFormatException e) {
			//例外発生時の処理		

			model.addAttribute("result", "数字以外が入力されています。");
			return "calculator.html";
		}

		return "calculator.html";//calculator.htmlに画面遷移
	}

}
