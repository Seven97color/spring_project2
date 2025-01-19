package com.example.demo.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	public int calculator1(int int1, int int2) {
		int answer = int1 + int2;//足し算の計算式			
		return answer;
	}

	public int calculator2(int int1, int int2) {
		int answer = int1 - int2;//引き算の計算式
		return answer;
	}

	public int calculator3(int int1, int int2) {
		int answer = int1 * int2;//掛け算の計算式
		return answer;
	}

	public String calculator4(int int1, int int2) {
		int answer = 0;
		String result = "";
		try {
			answer = int1 / int2;//割り算の計算式	
			result = String.valueOf(answer);
			// 0で割るとArithmeticExceptionが発生
		} catch (ArithmeticException e) {
			result = "0で割ることはできません。";
		}
		return result;
	}
}
