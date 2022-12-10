package com.softgraf.primavera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.softgraf.primavera.data.repository.ProdutoRepository;

@Controller
public class HomeController {

	@Autowired
	private ProdutoRepository repository;

	@GetMapping("/home")
	public String home(Model model) {
		// objeto responsável por enviar dados para o front-end
		model.addAttribute("produtos", repository.findAll());
		model.addAttribute("uploads", "/uploads/");

		// carrega "templates/home.html"
		return "home";
	}

	@GetMapping("/sobre")
	public String sobre(Model model) {
		return "sobre";
	}

	@GetMapping("/")
	public String index(Model model) {
		return "redirect:/home";
	}

}
