package com.example.demo.minus;

import org.springframework.stereotype.Service;

@Service
public class MinusService {

	public String minus(String num1, String num2) {//num1num2をString型に変えることによって数字以外も反応できるように処理

		int int1 = 0;
		int int2 = 0;

		try {
			if (num1.isEmpty() || num2.isEmpty()) { //num1,num2が空かどうか確認する条件処理
				//条件がtrueの場合
				String result = "何も入力されていません";
				return result;
			} else {
				int1 = Integer.parseInt(num1);//String型からint型に適用できるように変換処理
				int2 = Integer.parseInt(num2);
			}
			//例外が発生しうる処理
		} catch (NumberFormatException e) {
			//例外発生時の処理		
			System.out.println("数値に変換できません。");
			String str1 = "数字以外が入力されています。";
			return str1;
		}
		int answer = int1 - int2;//マイナスの計算式
		String str = String.valueOf(answer);
		return str;

	}

}
