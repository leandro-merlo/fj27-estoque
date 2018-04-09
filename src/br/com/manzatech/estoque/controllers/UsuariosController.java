package br.com.manzatech.estoque.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuariosController {

	@GetMapping("/login")
	public String index() {
		return "usuarios/login";
	}

}
