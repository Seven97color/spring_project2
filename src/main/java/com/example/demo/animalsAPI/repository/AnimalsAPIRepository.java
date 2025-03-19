package com.example.demo.animalsAPI.repository;

import java.io.IOException;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.demo.animalsAPI.data.AnimalsAPIData;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class AnimalsAPIRepository {

	public AnimalsAPIData[] getAnimals() throws IOException {
		String url = "https://wsaz0e6z45.execute-api.ap-northeast-1.amazonaws.com/prod/animalsAPI";
		RestTemplate rest = new RestTemplate();
		String response = rest.getForObject(url, String.class);

		// JSON文字列をAnimalsAPIDataの配列に変換
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(response, AnimalsAPIData[].class);
	}

	public AnimalsAPIData[] getAnimalById(int id) throws IOException {
		String url = "https://wsaz0e6z45.execute-api.ap-northeast-1.amazonaws.com/prod/animalsAPI?id="
				+ String.valueOf(id);
		RestTemplate rest = new RestTemplate();
		String response = rest.getForObject(url, String.class);

		// JSON文字列をAnimalsAPIDataオブジェクトに変換
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(response, AnimalsAPIData[].class);
	}
}

//外部APIにHTTP GETリクエストを送信し、JSON形式で返される動物データを取得
//RestTemplateを使用してAPI呼び出しを行い、JSON文字列を受け取る
