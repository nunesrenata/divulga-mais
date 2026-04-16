package br.com.renata.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "Projeto Divulga Mais rodando com sucesso! API disponível em /servicos, /avaliacoes e /contatos";

	}
}