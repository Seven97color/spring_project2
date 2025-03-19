package com.example.demo.animalsAPI.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.animalsAPI.data.AnimalsAPIData;
import com.example.demo.animalsAPI.service.AnimalsAPIService;

@Controller
public class AnimalsAPIController {

	private final AnimalsAPIService animalsAPIService;

	public AnimalsAPIController(AnimalsAPIService animalsAPIService) {
		this.animalsAPIService = animalsAPIService;
	}

	@GetMapping("/animalsAPI")
	public String showAnimals(Model model) throws IOException {
		List<AnimalsAPIData> animalsList = animalsAPIService.getAnimals();
		model.addAttribute("animalsAPI", animalsList);
		return "animalsAPI";
	}

	@GetMapping("/animalsDetailAPI")
	public String showDetail(@RequestParam int id, Model model) throws IOException {
		List<AnimalsAPIData> animals = animalsAPIService.getAnimalById(id);
		model.addAttribute("animals", animals);
		return "animalsDetailAPI";
	}
}
