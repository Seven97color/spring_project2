package com.example.demo.animalsAPI.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.animalsAPI.data.AnimalsAPIData;
import com.example.demo.animalsAPI .service .AnimalsAPIService;

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

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable Long id, Model model) throws IOException {
    	AnimalsAPIData animal = animalsAPIService.getAnimalById(id);
        model.addAttribute("animal", animal);
        return "AnimalsDetailAPI";
    }
}

