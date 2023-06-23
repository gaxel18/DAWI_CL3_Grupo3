package com.example.DAWI_CL3_Grupo3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.DAWI_CL3_Grupo3.model.bd.Usuario;
import com.example.DAWI_CL3_Grupo3.service.UsuarioService_CL3;

@Controller
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private UsuarioService_CL3 usuarioServicecl3;
	@GetMapping("/login")
	public String login() {
		return "auth/frmLogincl3";
	}
	@GetMapping("/registrar")
	public String registrar() {
		return "auth/frmRegistrocl3";
	}
	@PostMapping("/guardarUsuario")
	public String guardarUsuario(
			@ModelAttribute Usuario usuario,
			Model model) {
		usuarioServicecl3.guardarUsuario(usuario);
		model.addAttribute("registroCorrecto",
				true);
		return "auth/frmRegistrocl3";
	}
}

