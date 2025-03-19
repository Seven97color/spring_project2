package com.example.demo.animalsAPI.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.animalsAPI.data.AnimalsAPIData;
import com.example.demo.animalsAPI.repository.AnimalsAPIRepository;

@Service
public class AnimalsAPIService {
	private final AnimalsAPIRepository animalsAPIRepository;

	public AnimalsAPIService(AnimalsAPIRepository animalsAPIRepository) {
		this.animalsAPIRepository = animalsAPIRepository;
	}

	public List<AnimalsAPIData> getAnimals() throws IOException {
		// 配列をリストに変換して返す
		return Arrays.asList(animalsAPIRepository.getAnimals());
	}

	public List<AnimalsAPIData> getAnimalById(int id) throws IOException {
		return Arrays.asList(animalsAPIRepository.getAnimalById(id));
	}
}
