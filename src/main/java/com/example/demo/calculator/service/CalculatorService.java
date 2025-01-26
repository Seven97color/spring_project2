package com.example.demo.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	public String calculator(String example, String str1, String str2) {

		if (str1.isEmpty() || str2.isEmpty()) { //num1,num2が空かどうか確認する条件処理
			//条件がtrueの場合
			return "何も入力されていません。";
		}

		try {
			int int1 = Integer.parseInt(str1);
			int int2 = Integer.parseInt(str2);
			int answer = 0;

			switch (example) {
			case "plus":
				answer = int1 + int2;
				break;
			case "minus":
				answer = int1 - int2;
				break;
			case "multi":
				answer = int1 * int2;
				break;
			case "divide":
				if (int2 == 0) {
					return "0で割ることはできません。";
				}
				answer = int1 / int2;
				break;
			}

			return String.valueOf(answer);
			//数字以外が入力されると例外処理が発生する
		} catch (NumberFormatException e) {
			return "数字以外が入力されています。";
		}
	}
}