package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

//Registra esta clase como un controlador, se buscara en ComponentScan.
@Controller 
@RequestMapping("/app")
public class IndexController {
	
	private String titulo;
	
	//Mapear
	//@GetMapping(value="/index")
	//@RequestMapping(value="/index", method = RequestMethod.GET)
	@GetMapping({"/index", "/", "/home", ""})
	public String index(Model model) {
		this.titulo = "Hola Spring Framework";
		model.addAttribute("titulo", this.titulo);
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {		
		Usuario usuario = new Usuario();
		usuario.setNombre("Juan");
		usuario.setApellido("Gonzalez");
		usuario.setEmail("juanftp100@gmail.com");
		model.addAttribute("usuario", usuario);		
		model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		this.titulo = "Listado de Usuarios";
//		List<Usuario> usuarios = new ArrayList<>();
//		usuarios.add(new Usuario("Juan", "Gonzalez", "juanftp100@gmail.com"));
//		usuarios.add(new Usuario("Celina", "Ramirez", "chili.olimpera@gmail.com"));
		
		List<Usuario> usuarios = Arrays.asList(
				new Usuario("Juan", "Gonzalez", "juanftp100@gmail.com")
				, new Usuario("Celina", "Ramirez", "chili.olimpera@gmail.com")
				, new Usuario("Jose", "DiMartino", null)
				);
		model.addAttribute("titulo", this.titulo);
		model.addAttribute("usuarios", usuarios);
		return "listar";
	}
	
}
