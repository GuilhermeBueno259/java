package com.softgraf.primavera.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	// cria uma rota para o navegador
	// localhost:8080/hello
	// este método é uma Action que atende uma requesição Http
//	@GetMapping("/hello")
//	public String hello(HttpServletRequest request) {
// USA UMA REQUISIÇÃO HTTP SERVLET PARA SALVAR DADOS PARA O FRONT-END
	// request.setAttribute("nome", "João da Silva");
//
//		return "Hello";
//	}

	@GetMapping("/hello")
	// a action hello recebe um objeto model que representa dos dados para o
	// front-end
	public String hello(Model model) {
		model.addAttribute("nome", "João da Silva");

		return "hello";
	}

}
